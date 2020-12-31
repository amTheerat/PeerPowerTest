package th.test.loan.usecase

import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.repo.LoanRepository
import java.lang.Exception

interface DeleteLoanUseCase {
    suspend fun execute(id: Int): UseCaseResult<Nothing>
}

class DeleteLoanUseCaseImpl(
    private val loanRepository: LoanRepository
) : DeleteLoanUseCase {

    override suspend fun execute(id: Int): UseCaseResult<Nothing> {
        return try {
            loanRepository.deleteLoan(id = id)
            UseCaseResult.Complete
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}