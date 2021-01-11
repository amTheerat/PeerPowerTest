package th.test.auth.data.entity.response

import com.google.gson.annotations.SerializedName
import th.test.auth.data.entity.model.UserModel

data class UserResponse(
    @SerializedName("data")
    var data: UserModel
)