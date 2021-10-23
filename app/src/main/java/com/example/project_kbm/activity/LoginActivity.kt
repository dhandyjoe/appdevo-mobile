package com.example.project_kbm.activity

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.project_kbm.R
import com.example.project_kbm.database.Constants
import com.example.project_kbm.database.Constants.DATA_USERS
import com.example.project_kbm.database.Constants.RC_SIGN_IN

import com.example.project_kbm.databinding.ActivityLoginBinding
import com.example.project_kbm.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.config.GservicesValue.value
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityLoginBinding
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDB = FirebaseFirestore.getInstance()
    private var userID = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        googleSignIn()

        binding.tvForgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            var status = true
            if (binding.tvEmail.text.isEmpty()) {
                binding.tvEmail.error = "Email is required"
                status = false
            }
            if (binding.tvPassword.text.isEmpty()) {
                binding.tvPassword.error = "Password is required"
                status = false
            }
            if (status) {
                signInEmail()
            }
        }

        binding.btnLoginGoogle.setOnClickListener {
            signInGmail()
        }
    }

    private fun signInEmail() {
        firebaseAuth.signInWithEmailAndPassword(binding.tvEmail.text.toString(), binding.tvPassword.text.toString())
            .addOnCompleteListener {
                if(!it.isSuccessful) {
                    Toast.makeText(this, "Email / Password Incorrect!", Toast.LENGTH_SHORT).show()
                } else if (firebaseAuth.uid != null) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
    }

    private fun googleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun signInGmail() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
//        resultLauncher.launch(signInIntent)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    account()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Sorry auth failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

//    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//        if (it.resultCode == Activity.RESULT_OK) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)!!
//                firebaseAuthWithGoogle(account.idToken!!)
//                Log.d("testGoogle", "success")
//            } catch (e: ApiException) {
//                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e)
//            }
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val accounts = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(accounts.idToken!!)
                Log.d("testGoogle", "success")
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun account () {
//        firebaseDB.collection(DATA_USERS).document(userID!!).get()
//            .addOnSuccessListener {
//                val user = it.toObject(User::class.java)
//
//                if (user == null) {
//                    val signInAccount = firebaseAuth.currentUser
//                    val name = signInAccount?.displayName.toString()
//                    val email = signInAccount?.email.toString()
//
//                    val userAccount = User(name, email, "")
//                    firebaseDB.collection(DATA_USERS).document(firebaseAuth.uid!!).set(userAccount)
//                }
//            }

        if (firebaseAuth.uid != null) {
            val signInAccount = firebaseAuth.currentUser
            val name = signInAccount?.displayName.toString()
            val email = signInAccount?.email.toString()

            val userAccount = User(name, email, "")
            firebaseDB.collection(DATA_USERS).document(firebaseAuth.uid!!).set(userAccount)
        }
    }
}