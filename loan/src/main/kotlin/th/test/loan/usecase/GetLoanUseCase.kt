package th.test.loan.usecase

import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.repo.LoanRepository
import java.lang.Exception

interface GetLoanUseCase {
    suspend fun execute(id: Int): UseCaseResult<LoanModel>
}

class GetLoanUseCaseImpl(
    private val loanRepository: LoanRepository
) : GetLoanUseCase {

    override suspend fun execute(id: Int): UseCaseResult<LoanModel> {
        return try {
            val loanResult = loanRepository.getLoan(id = id)
            UseCaseResult.Success(loanResult)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}