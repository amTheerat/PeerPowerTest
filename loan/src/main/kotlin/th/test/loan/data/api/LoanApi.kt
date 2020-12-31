package th.test.loan.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import th.test.loan.data.entity.request.CreateLoanRequest
import th.test.loan.data.entity.response.CreateLoanResponse

interface LoanApi {

    @POST("api/loans/{id}")
    suspend fun createLoan(
        @Body getActivityLogsRequest: CreateLoanRequest
    ): CreateLoanResponse

}
