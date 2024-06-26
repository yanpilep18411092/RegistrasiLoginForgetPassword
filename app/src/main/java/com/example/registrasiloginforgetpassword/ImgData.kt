package com.example.registrasiloginforgetpassword

import com.bumptech.glide.annotation.Excludes
import com.google.firebase.database.Exclude

data class ImgData(
    var name:String? = null,
    var nomorhp:String? = null,
    var alamat:String? = null,
    var fotoUrl:String? = null,
    var desc:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null
)
