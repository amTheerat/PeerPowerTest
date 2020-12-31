package th.test.auth.data.entity.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(

    @SerializedName("token_type")
    var token_type: String,

    @SerializedName("expires_in")
    var expires_in: String,

    @SerializedName("access_token")
    var access_token: String,

    @SerializedName("refresh_token")
    var refresh_token: String

)