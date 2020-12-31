package th.test.auth.data.entity.model

import com.google.gson.annotations.SerializedName

data class TokenModel(
    var access_token: String? = null,
    var refresh_token: String? = null
)
