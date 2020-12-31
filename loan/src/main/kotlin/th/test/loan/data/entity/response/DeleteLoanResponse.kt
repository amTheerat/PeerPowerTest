package th.test.loan.data.entity.response

import com.google.gson.annotations.SerializedName
import java.security.MessageDigest

data class DeleteLoanResponse(
    @SerializedName("message")
    var message: String
)
