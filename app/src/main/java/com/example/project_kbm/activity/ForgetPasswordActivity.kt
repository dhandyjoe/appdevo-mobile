package com.example.project_kbm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project_kbm.R
import com.example.project_kbm.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            if (binding.evForgetPassword.text.isEmpty()) {
                Toast.makeText(this, "Please enter email address.", Toast.LENGTH_SHORT).show()
            } else {
                firebaseAuth.sendPasswordResetEmail(binding.evForgetPassword.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Email sent successfully to reset yout password", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}