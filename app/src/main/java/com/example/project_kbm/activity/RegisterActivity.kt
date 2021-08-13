package com.example.project_kbm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.project_kbm.R
import com.example.project_kbm.databinding.ActivityRegisterBinding
import com.example.project_kbm.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var firebaseDB = FirebaseFirestore.getInstance()
    val DATA_USERS = "Users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun register() {
        firebaseAuth.createUserWithEmailAndPassword(binding.tvEmail.text.toString(), binding.tvPassword.text.toString())
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    startActivity(Intent(this, RegisterActivity::class.java))
                } else if (firebaseAuth.uid != null) {
                    val name = binding.tvName.text.toString()
                    val email = binding.tvEmail.text.toString()
                    val user = User(name, email)
                    firebaseDB.collection(DATA_USERS).document(firebaseAuth.uid!!).set(user)

                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
            .addOnFailureListener {
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }
}