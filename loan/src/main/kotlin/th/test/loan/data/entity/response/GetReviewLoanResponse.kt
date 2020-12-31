package th.test.loan.data.entity.response

import com.google.gson.annotations.SerializedName
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.entity.model.RepaymentSchedulesModel

data class GetReviewLoanResponse(
    @SerializedName("data")
    var data: List<RepaymentSchedulesModel>
)
