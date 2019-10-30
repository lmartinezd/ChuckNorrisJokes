package com.lmf.chucknorrisjokes.data.model

import com.google.gson.annotations.SerializedName

data class ResponseJoke (
    @SerializedName("icon_url")
    val iconUrl: String,
    val url: String,
    val value: String
)