package com.example.countrydata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Flags {
    @SerializedName("svg")
    @Expose
    var svg: String? = null

    @SerializedName("png")
    @Expose
    var png: String? = null
}