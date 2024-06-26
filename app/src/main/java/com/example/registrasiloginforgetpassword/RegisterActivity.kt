package com.example.registrasiloginforgetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.registrasiloginforgetpassword.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth
    
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {

            val email = binding.edtEmailReg.text.toString()
            val username = binding.edtUsernameReg.text.toString()
            val password = binding.edtPasswordReg.text.toString()
            val retypePass = binding.edtRetypePassReg.text.toString()

            // Cek Username
            if (username.isEmpty()) {
                binding.edtUsernameReg.error = "Username harus diisi"
                binding.edtUsernameReg.requestFocus()
                return@setOnClickListener
            }

            // Cek E-Mail
            if (email.isEmpty()) {
                binding.edtEmailReg.error = "E-Mail harus diisi"
                binding.edtEmailReg.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmailReg.error = "E-Mail harus Valid"
                binding.edtEmailReg.requestFocus()
                return@setOnClickListener
            }

            // Cek Password
            if (password.isEmpty()) {
                binding.edtPasswordReg.error = "Password harus diisi"
                binding.edtPasswordReg.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6 ) {
                binding.edtPasswordReg.error = "Password minimal 6 karakter!"
                binding.edtPasswordReg.requestFocus()
                return@setOnClickListener
            }

            // Cek Apakah Password != RetypePassword
            if (password != retypePass) {
                binding.edtRetypePassReg.error = "Password tidak sama"
                binding.edtRetypePassReg.requestFocus()
                return@setOnClickListener
            }

            daftarUserFirebase(email, password)
        }

        // Link untuk berpindah ke halaman Login
        binding.tvLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    // Fungsi untuk mendaftarkan user
    private fun daftarUserFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
//                    startActivity(Intent(this, LoginActivity::class.java))
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            } else {
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }










}