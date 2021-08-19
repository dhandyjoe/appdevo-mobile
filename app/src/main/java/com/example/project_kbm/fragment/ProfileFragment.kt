package com.example.project_kbm.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.project_kbm.R
import com.example.project_kbm.activity.LoginActivity
import com.example.project_kbm.activity.MainActivity
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
    private lateinit var thisContext: Context
    private lateinit var binding: FragmentProfileBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val userID = FirebaseAuth.getInstance().currentUser!!.uid
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
    ): View? {
        thisContext = container!!.context
        val signInAccount = GoogleSignIn.getLastSignedInAccount(thisContext)
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)

        if (signInAccount != null) {
            binding.tvNameProfile.text = signInAccount.displayName
            binding.tvEmailProfile.text = signInAccount.email
            Glide.with(thisContext).load(signInAccount.photoUrl).into(binding.profileImage)
        } else {
            firebaseDB.collection(DATA_USERS).document(userID)
                .get()
                .addOnSuccessListener {
                    val user = it.toObject(User::class.java)
                    binding.tvNameProfile.text = user!!.name
                    binding.tvEmailProfile.text = user!!.email
                }
        }

        binding.btnLogout.setOnClickListener {
            mGoogleSignInClient.signOut()
                .addOnCompleteListener {
                    Toast.makeText(activity, "berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(activity, LoginActivity::class.java)
                    startActivity(intent)
                }
        }


        return binding.root
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