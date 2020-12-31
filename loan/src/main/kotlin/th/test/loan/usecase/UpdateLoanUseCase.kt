package th.test.loan.usecase

import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.repo.LoanRepository
import java.lang.Exception

interface UpdateLoanUseCase {
    suspend fun execute(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): UseCaseResult<LoanModel>
}

class UpdateLoanUseCaseImpl(
    private val loanRepository: LoanRepository
) : UpdateLoanUseCase {

    override suspend fun execute(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ): UseCaseResult<LoanModel> {
        return try {
            val loanResult = loanRepository.updateLoan(
                id = id,
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