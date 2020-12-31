package th.test.loan.usecase

import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.entity.model.RepaymentSchedulesModel
import th.test.loan.data.repo.LoanRepository
import java.lang.Exception

interface GetReviewLoanListUseCase {
    suspend fun execute(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): UseCaseResult<List<RepaymentSchedulesModel>>
}

class GetReviewLoanListUseCaseImpl(
    private val loanRepository: LoanRepository
) : GetReviewLoanListUseCase {

    override suspend fun execute(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): UseCaseResult<List<RepaymentSchedulesModel>> {
        return try {
            val loanResult = loanRepository.getReviewLoanList(
                loanAmount = loanAmount,
                loanTerm = loanTerm,
                interestRate = interestRate,
                startMonth = startMonth,
                startYear = startYear
            )
            UseCaseResult.Success(loanResult)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}