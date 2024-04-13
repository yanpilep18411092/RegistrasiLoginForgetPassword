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

        // Tombol berpindah ke halaman Home
        binding.btnLogin.setOnClickListener {

            val activityHome = Intent(this, MainActivity::class.java)
            startActivity(activityHome)
            finish()

            //Pesan saat pindah ke halaman Home
            Toast.makeText(this, "Welcome to Home page", Toast.LENGTH_SHORT).show()
        }

        // Link untuk berpindah ke halaman lupa Password
        binding.linkForgetPassword.setOnClickListener{
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)

            // Pesan saat pindah ke halaman forget password
            Toast.makeText(this, "Halaman forget password", Toast.LENGTH_SHORT).show()
        }

        // Link untuk berpindah ke halaman Register
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

            //Pesan saat pindah ke halaman register
            Toast.makeText(this, "Halaman Registrasi", Toast.LENGTH_SHORT).show()
        }
    }
}