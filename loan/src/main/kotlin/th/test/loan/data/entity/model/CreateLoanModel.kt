package th.test.loan.data.entity.model

import com.google.gson.annotations.SerializedName

data class CreateLoanModel(

    /* Example data
        "id": 23,
        "loan_amount": 1000000,
        "loan_term": 12,
        "interest_rate": 0.1023,
        "repayment_schedules": [
            {
                "id": 625,
                "loan_id": 23,
                "payment_no": 1,
                "date": "2020-05-31T17:00:00.000000Z",
                "payment_amount": "88022.894196",
                "principal": "79497.894196",
                "interest": "8525.000000",
                "balance": "920502.105804",
                "created_at": "2020-01-24T08:52:09.000000Z",
                "updated_at": "2020-01-24T08:52:09.000000Z"
            },
            {
                ...
            }
        ]
    * */

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("loan_amount")
    var loan_amount: Long? = null,

    @SerializedName("loan_term")
    var loan_term: Int? = null,

    @SerializedName("interest_rate")
    var interest_rate: Float? = null,

    @SerializedName("repayment_schedules")
    var repayment_schedules: List<RepaymentSchedulesModel>? = null

)

data class RepaymentSchedulesModel(

    /* Example data
    * {
                "id": 625,
                "loan_id": 23,
                "payment_no": 1,
                "date": "2020-05-31T17:00:00.000000Z",
                "payment_amount": "88022.894196",
                "principal": "79497.894196",
                "interest": "8525.000000",
                "balance": "920502.105804",
                "created_at": "2020-01-24T08:52:09.000000Z",
                "updated_at": "2020-01-24T08:52:09.000000Z"
      }
    * */

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("loan_id")
    var loan_id: Int? = null,

    @SerializedName("payment_no")
    var payment_no: Int? = null,

    @SerializedName("date")
    var date: String? = null,

    @SerializedName("principal")
    var principal: Float? = null,

    @SerializedName("interest")
    var interest: Float? = null,

    @SerializedName("balance")
    var balance: Float? = null,

    @SerializedName("created_at")
    var created_at: String? = null,

    @SerializedName("updated_at")
    var updated_at: String? = null
)