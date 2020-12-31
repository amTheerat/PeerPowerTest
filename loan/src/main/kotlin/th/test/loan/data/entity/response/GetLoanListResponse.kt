package th.test.loan.data.entity.response

import com.google.gson.annotations.SerializedName
import th.test.loan.data.entity.model.LoanModel

data class GetLoanListResponse(
    @SerializedName("data")
    var data: List<LoanModel>
)
