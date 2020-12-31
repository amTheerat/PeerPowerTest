package th.test.loan.data.repo

import th.test.loan.data.api.LoanApi
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.entity.model.RepaymentSchedulesModel
import th.test.loan.data.entity.request.LoanRequest
import th.test.loan.data.entity.response.DeleteLoanResponse

interface LoanRepository {

    suspend fun getLoan(id: Int): LoanModel

    suspend fun createLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): LoanModel

    suspend fun updateLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): LoanModel

    suspend fun deleteLoan(id: Int): DeleteLoanResponse

    suspend fun getLoanList(): List<LoanModel>

    suspend fun getReviewLoanList(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): List<RepaymentSchedulesModel>

}

class LoanRepositoryImpl(
    private val loanApi: LoanApi
) : LoanRepository {

    override suspend fun getLoan(
        id: Int
    ): LoanModel = loanApi.getLoan(id = id).data

    override suspend fun createLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): LoanModel = loanApi.createLoan(
        id = id,
        loanRequest = LoanRequest(
            loan_amount = loanAmount,
            loan_term = loanTerm,
            interest_rate = interestRate,
            start_month = startMonth,
            start_year = startYear
        )
    ).data

    override suspend fun updateLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): LoanModel = loanApi.updateLoan(
        id = id,
        loanRequest = LoanRequest(
            loan_amount = loanAmount,
            loan_term = loanTerm,
            interest_rate = interestRate,
            start_month = startMonth,
            start_year = startYear
        )
    ).data

    override suspend fun deleteLoan(
        id: Int
    ): DeleteLoanResponse = loanApi.deleteLoan(
        id = id
    )

    override suspend fun getLoanList(): List<LoanModel> = loanApi.getLoanList().data

    override suspend fun getReviewLoanList(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): List<RepaymentSchedulesModel> = loanApi.getPreviewLoanList(
        loanRequest = LoanRequest(
            loan_amount = loanAmount,
            loan_term = loanTerm,
            interest_rate = interestRate,
            start_month = startMonth,
            start_year = startYear
        )
    ).data

}