package com.padcmyanmar.padc9.themoviedbapp.data.vos

import com.google.gson.annotations.SerializedName

data class CompanyVO (
    @SerializedName("id")
    val id: Int,

    @SerializedName("logo_path")
    var logoPath: String? = null,

    @SerializedName("name")
    val name: String,

    @SerializedName("origin_country")
    val originCountry: String
)