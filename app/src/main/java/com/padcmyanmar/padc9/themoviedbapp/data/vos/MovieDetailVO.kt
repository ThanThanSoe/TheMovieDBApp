package com.padcmyanmar.padc9.themoviedbapp.data.vos

import com.google.gson.annotations.SerializedName

data class MovieDetailVO (
    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("budget")
    val budget:Int,

    @SerializedName("genres")
    val genres: List<GenreVO>,

    @SerializedName("homepage")
    val homePage: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("imdb_id")
    val imdbId: String,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("popularity")
    val popularity: Float,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("belongs_to_collection")
    val collection: CollectionVO,

    @SerializedName("production_companies")
    val productionCompanies: List<CompanyVO>,

    @SerializedName("production_countries")
    val countries: List<CountryVO>,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("revenue")
    val revenue: Int,

    @SerializedName("runtime")
    val runTime: Int,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<LanguageVO>,

    @SerializedName("status")
    val status: String,

    @SerializedName("tagline")
    val tagLine: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Float,

    @SerializedName("vote_count")
    val voteCount: Int
)