package th.test.loan.data.entity.request

import com.google.gson.annotations.SerializedName

data class CreateLoanRequest(

    //Loan amount (1,000-100,000,000THB)
    @SerializedName("loan_amount")
    var loan_amount: Int,

    //Loan term (1-36 Years)
    @SerializedName("loan_term")
    var loan_term: Int,

    //Interest rate (1-36%)
    @SerializedName("interest_rate")
    var interest_rate: Float,

    //Start month (1-12)
    @SerializedName("start_month")
    var start_month: Int,

    //Start year (2017-2050)
    @SerializedName("start_year")
    var start_year: Int

)