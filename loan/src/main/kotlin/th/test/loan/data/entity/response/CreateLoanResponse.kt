package th.test.loan.data.entity.response

import com.google.gson.annotations.SerializedName
import th.test.loan.data.entity.model.CreateLoanModel

data class CreateLoanResponse(
    @SerializedName("data")
    var data: CreateLoanModel
)
