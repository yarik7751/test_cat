package by.yarik.core.network.pojo

import com.google.gson.annotations.SerializedName

data class CatsResponse(
    @SerializedName("height")
    var height: Int,
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("width")
    var width: Int
)