package com.example.registrasiloginforgetpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.registrasiloginforgetpassword.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    // Autentikasi Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        // Tombol Login
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            // Cek E-Mail
            if (email.isEmpty()) {
                binding.edtEmail.error = "E-Mail harus diisi"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmail.error = "E-Mail harus Valid"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }

            // Cek Password
            if (password.isEmpty()) {
                binding.edtPassword.error = "Password harus diisi"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6 ) {
                binding.edtPassword.error = "Password minimal 6 karakter!"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }

            loginUserFirebase(email, password)
        }


        // Link ke halaman lupa Password
        binding.linkForgetPassword.setOnClickListener{
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)

            // Pesan saat pindah ke halaman forget password
            Toast.makeText(this, "Halaman forget password", Toast.LENGTH_SHORT).show()
        }

        // Link ke halaman Register
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

            //Pesan saat pindah ke halaman register
            Toast.makeText(this, "Halaman Registrasi", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loginUserFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
                finish()
            } else {
                Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this, MainActivity2::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }


}