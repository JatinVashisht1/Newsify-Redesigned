package com.example.newsifyredesigned.data.remote.dto_chip_response


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: Any? = null,
    @SerializedName("name")
    val name: String = ""
)