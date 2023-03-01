package com.example.countrydata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegionalBloc {
    @SerializedName("acronym")
    @Expose
    var acronym: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}