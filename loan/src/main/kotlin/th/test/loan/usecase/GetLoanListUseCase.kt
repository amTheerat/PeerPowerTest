package th.test.loan.usecase

import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.repo.LoanRepository
import java.lang.Exception

interface GetLoanListUseCase {
    suspend fun execute(): UseCaseResult<List<LoanModel>>
}

class GetLoanListUseCaseImpl(
    private val loanRepository: LoanRepository
) : GetLoanListUseCase {

    override suspend fun execute(): UseCaseResult<List<LoanModel>> {
        return try {
            val loanResult = loanRepository.getLoanList()
            UseCaseResult.Success(loanResult)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}