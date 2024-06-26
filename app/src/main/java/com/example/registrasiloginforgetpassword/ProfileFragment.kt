package com.example.registrasiloginforgetpassword

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.registrasiloginforgetpassword.databinding.ActivityProfileBinding
import com.example.registrasiloginforgetpassword.databinding.FragmentProfileBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream
import com.google.firebase.storage.FirebaseStorage as FirebaseStorage

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    lateinit var auth: FirebaseAuth
    lateinit var imgUri: Uri



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using view binding
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null) {
            binding.namaUser.setText(user.displayName)
            binding.emailUser.setText(user.email)

            if (user.photoUrl != null) {
                Picasso.get().load(user.photoUrl).into(binding.ivProfile)
            } else {
                Picasso.get().load("").into(binding.ivProfile)
            }
        }


        // Access UI elements using view binding
        binding.btnLogout.setOnClickListener {
            // Keluar dan tutup aplikasi
            // activity?.finishAffinity()
            // tombolLogout()
        }

        binding.ivProfile.setOnClickListener {
            goToCamera()
        }

        binding.btnSave.setOnClickListener btnSave@{
            val image = when {
                ::imgUri.isInitialized -> imgUri
                user?.photoUrl == null -> Uri.parse("")
                else -> user.photoUrl
            }

            val name = binding.namaUser.text.toString()

            if (name.isEmpty()){
                binding.namaUser.error = "Nama belum di isi !"
                binding.namaUser.requestFocus()
                return@btnSave
            }

            // update data
            UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(image)
                .build().also {
                    user?.updateProfile(it)?.addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            val toast = Toast.makeText(activity, "Data berhasil disimpan", Toast.LENGTH_SHORT)
                            toast.setGravity(Gravity.CENTER_VERTICAL,0,0)
                            toast.show()
                        } else {
                            Toast.makeText(activity, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }

    private fun goToCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            activity?.packageManager?.let {
                intent?.resolveActivity(it).also {
                    startActivityForResult(intent, REQ_CODE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            val imgBitmap = data?.extras?.get("data") as Bitmap

            uploadImgToFirebase(imgBitmap)
        }
    }

    private fun uploadImgToFirebase(imgBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()

        // Masuk ke direktori firebase
        val ref = FirebaseStorage.getInstance().reference.child("image_user/${FirebaseAuth.getInstance().currentUser?.email}")
        imgBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)

        val img = baos.toByteArray()
        ref.putBytes(img)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    ref.downloadUrl.addOnCompleteListener { Task ->
                        Task.result?.let { uri ->
                            imgUri = uri
                            binding.ivProfile.setImageBitmap(imgBitmap)
                        }
                    }
                }
            }


    }

    private fun tombolLogout() { // Function Logout
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val i = Intent(context, LoginActivity::class.java)
        startActivity(i)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Release the binding when the fragment's view is destroyed
        _binding = null
    }

    companion object {
        const val REQ_CODE = 100
    }




}