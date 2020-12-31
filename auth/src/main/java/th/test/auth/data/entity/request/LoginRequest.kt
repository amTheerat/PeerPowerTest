package th.test.auth.data.entity.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("grant_type")
    var grant_type: String = "password",

    @SerializedName("client_id")
    var client_id: String,

    @SerializedName("client_secret")
    var client_secret: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String

)