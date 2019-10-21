package com.padcmyanmar.padc9.themoviedbapp.data.vos

import com.google.gson.annotations.SerializedName

data class LanguageVO (
    @SerializedName("iso_639_1")
    val iso: String,

    @SerializedName("name")
    val name: String
)