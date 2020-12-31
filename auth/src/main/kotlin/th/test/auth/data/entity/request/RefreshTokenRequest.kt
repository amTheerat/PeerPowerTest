package th.test.auth.data.entity.request

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest(

    @SerializedName("grant_type")
    var grant_type: String = "refresh_token",

    @SerializedName("client_id")
    var client_id: String,

    @SerializedName("client_secret")
    var client_secret: String,

    @SerializedName("refresh_token")
    var refresh_token: String

)