package th.test.auth.data.entity.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("created_at")
    var created_at: String,

    @SerializedName("updated_at")
    var updated_at: String

)