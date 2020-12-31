package th.test.loan.data.api

import retrofit2.http.*
import th.test.loan.data.entity.request.LoanRequest
import th.test.loan.data.entity.response.LoanResponse
import th.test.loan.data.entity.response.DeleteLoanResponse
import th.test.loan.data.entity.response.GetLoanResponse
import th.test.loan.data.entity.response.GetReviewLoanResponse

interface LoanApi {

    @POST("api/loans/{id}")
    suspend fun createLoan(
        @Path("id") id: Int,
        @Body loanRequest: LoanRequest
    ): LoanResponse

    @DELETE("api/loans/{id}")
    suspend fun deleteLoan(
        @Path("id") id: Int
    ): DeleteLoanResponse

    @GET("api/loans/{id}")
    suspend fun getLoan(
        @Path("id") id: Int
    ): GetLoanResponse

    @GET("api/loans")
    suspend fun getLoanList(): GetLoanResponse

    @GET("api/loans/preview")
    suspend fun getPreviewLoanList(
        @Body loanRequest: LoanRequest
    ): GetReviewLoanResponse

    @PUT("api/loans/{id}")
    suspend fun updateLoan(
        @Path("id") id: Int,
        @Body loanRequest: LoanRequest
    ): LoanResponse
}
