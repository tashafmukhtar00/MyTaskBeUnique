package com.example.mytaskbeunique.model

import com.squareup.moshi.Json

data class DataY(


    @Json(name = "__v")
    val __v: Int,

    @Json(name = "_id")
    val _id: String,

    @Json(name = "date")
    val date: String,

    @Json(name = "image")
    val image: String,

    @Json(name = "interests")
    val interests: List<Interest>,

    @Json(name = "name")
    val name: String,

    @Json(name = "premium")
    val premium: Boolean,

    @Json(name = "selection")
    val selection: String,

    @Json(name = "slug")
    val slug: String,

    @Json(name = "url")
    val url: String
)