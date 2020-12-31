package th.test.auth.data.entity.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("created_at")
    var created_at: String? = null,

    @SerializedName("updated_at")
    var updated_at: String? = null

)