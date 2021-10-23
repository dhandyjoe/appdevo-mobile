package com.example.project_kbm.fragment

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project_kbm.R
import com.example.project_kbm.activity.LoginActivity
import com.example.project_kbm.database.Constants.DATA_IMAGE
import com.example.project_kbm.database.Constants.DATA_IMAGE_URL
import com.example.project_kbm.database.Constants.DATA_USERS
import com.example.project_kbm.databinding.FragmentProfileBinding
import com.example.project_kbm.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var imageUrl: String? = null
    private lateinit var thisContext: Context
    private lateinit var binding: FragmentProfileBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val userID = FirebaseAuth.getInstance().currentUser?.uid
    private val firebaseStorage = FirebaseStorage.getInstance().reference
    private val firebaseDB: FirebaseFirestore = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        thisContext = container!!.context
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        userInfo()

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                storeImage(it.data!!.data)
            }
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)

        binding.btnLogout.setOnClickListener {
            showAlertLogout()
        }

        binding.profileImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            resultLauncher.launch(intent)
        }


        return binding.root
    }

    private fun userInfo() {
        firebaseDB.collection(DATA_USERS)
            .document(userID!!)
            .get()
            .addOnSuccessListener {
                val user = it.toObject(User::class.java)
                imageUrl = user?.imageUrl
                binding.tvNameProfile.text = user?.name
                binding.tvEmailProfile.text = user?.email

                if (imageUrl == "") {
                    binding.profileImage.setImageResource(R.drawable.user_profile)
                } else {
                    userImage(thisContext, imageUrl!!, binding.profileImage)
                }
            }
    }

    private fun userImage(context: Context, uri: String, imageView: ImageView) {
        val option = RequestOptions().placeholder(progresDrawable(context))
        Glide.with(context)
            .load(uri)
            .apply(option)
            .into(imageView)
    }

    private fun progresDrawable(context: Context): CircularProgressDrawable {
        return CircularProgressDrawable(context).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
    }

    private fun storeImage(imageUri: Uri?) {
        if (imageUri != null) {
            Toast.makeText(thisContext, "Uploading...", Toast.LENGTH_SHORT).show()
            val filePath = firebaseStorage.child(DATA_IMAGE).child(userID!!)

            filePath.putFile(imageUri)
                .addOnSuccessListener {
                    filePath.downloadUrl
                        .addOnSuccessListener {
                            val url = it.toString()
                            firebaseDB.collection(DATA_USERS)
                                .document(userID)
                                .update(DATA_IMAGE_URL, url)
                                .addOnSuccessListener {
                                    imageUrl = url
                                    userImage(thisContext, imageUrl!!, binding.profileImage)
                                }
                        }
                        .addOnFailureListener {
                            Toast.makeText(thisContext, "Image Upload failed. Please try again later.", Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener {
                    Toast.makeText(thisContext, "Image Upload failed. Please try again later.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun showAlertLogout() {
        val alert = AlertDialog.Builder(thisContext)
        alert.setIcon(R.mipmap.ic_fti_update_round)
        alert.setTitle("Logout")
        alert.setMessage("Are you sure you want to logout?")
        alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            mGoogleSignInClient.signOut()
                .addOnCompleteListener {
                    val intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            Firebase.auth.signOut()
        })

        alert.setNegativeButton("No") { dialog, which ->

        }
        alert.show()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}