package com.app.pranrflgroupproject.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class CommonResponse(
    @SerializedName("message")
    var message: String = "",
    @SerializedName("status")
    var status: Boolean = false,
    var statusCode: Int = 200
): Serializable