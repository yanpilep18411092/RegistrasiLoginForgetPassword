package com.example.registrasiloginforgetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.registrasiloginforgetpassword.databinding.ActivityForgetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding
    // private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSendUrlVerify.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()

            // Cek E-Mail
            if (email.isEmpty()) {
                binding.editTextTextEmailAddress.error = "E-Mail harus diisi"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextTextEmailAddress.error = "E-Mail harus Valid"
                binding.editTextTextEmailAddress.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this,"Cek email for reset password", Toast.LENGTH_SHORT).show()
                    Intent(this, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }


        }

        binding.backToLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this, "Halaman login", Toast.LENGTH_SHORT).show()
        }



    }




}