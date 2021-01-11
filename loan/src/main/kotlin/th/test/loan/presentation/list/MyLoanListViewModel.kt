package th.test.loan.presentation.list

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import th.test.core.presentation.base.BaseViewModel
import th.test.core.utils.SingleLiveEvent
import th.test.core.utils.UseCaseResult
import th.test.loan.data.entity.model.LoanModel
import th.test.loan.data.entity.model.RepaymentSchedulesModel
import th.test.loan.usecase.*

class MyLoanListViewModel(
    private val createLoanUseCase: CreateLoanUseCase,
    private val deleteLoanUseCase: DeleteLoanUseCase,
    private val getLoanListUseCase: GetLoanListUseCase,
    private val getLoanUseCase: GetLoanUseCase,
    private val getReviewLoanListUseCase: GetReviewLoanListUseCase,
    private val updateLoanUseCase: UpdateLoanUseCase
): BaseViewModel() {

    val renderLoanList = MutableLiveData<List<LoanModel>>()
    val renderLoan = MutableLiveData<LoanModel>()
    val renderReviewLoanList = MutableLiveData<List<RepaymentSchedulesModel>>()
    val renderErrorView = SingleLiveEvent<Unit>()

    val showLoadingDialog = SingleLiveEvent<Boolean>()
    val showLoadingView = SingleLiveEvent<Boolean>()

    val alertMessageCreateLoanSuccess = SingleLiveEvent<Unit>()
    val alertMessageUpdateLoanSuccess = SingleLiveEvent<Unit>()
    val alertMessageDeleteLoanSuccess = SingleLiveEvent<Unit>()

    val alertMessageCreateLoanFailed = SingleLiveEvent<Unit>()
    val alertMessageUpdateLoanFailed = SingleLiveEvent<Unit>()
    val alertMessageDeleteLoanFailed = SingleLiveEvent<Unit>()
    val alertMessageGetLoanFailed = SingleLiveEvent<Unit>()
    val alertMessageGetReviewLoanFailed = SingleLiveEvent<Unit>()

    fun createLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ) {
        launch {
            showLoadingDialog.value = true
            val createLoanResult = createLoanUseCase.execute(
                id = id,
                loanAmount = loanAmount,
                loanTerm = loanTerm,
                interestRate = interestRate,
                startMonth = startMonth,
                startYear = startYear
            )
            if (createLoanResult is UseCaseResult.Success) {
                showLoadingDialog.value = false
                alertMessageCreateLoanSuccess.call()
            } else if (createLoanResult is UseCaseResult.Error){
                showLoadingDialog.value = false
                alertMessageCreateLoanFailed.call()
            }
        }
    }

    fun updateLoan(
        id: Int,
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ) {
        launch {
            showLoadingDialog.value = true
            val createLoanResult = updateLoanUseCase.execute(
                id = id,
                loanAmount = loanAmount,
                loanTerm = loanTerm,
                interestRate = interestRate,
                startMonth = startMonth,
                startYear = startYear
            )
            if (createLoanResult is UseCaseResult.Success) {
                showLoadingDialog.value = false
                alertMessageUpdateLoanSuccess.call()
            } else if (createLoanResult is UseCaseResult.Error){
                showLoadingDialog.value = false
                alertMessageUpdateLoanFailed.call()
            }
        }
    }

    fun deleteLoan(
        id: Int
    ) {
        launch {
            showLoadingDialog.value = true
            val createLoanResult = deleteLoanUseCase.execute(
                id = id
            )
            if (createLoanResult is UseCaseResult.Success) {
                showLoadingDialog.value = false
                alertMessageDeleteLoanSuccess.call()
            } else if (createLoanResult is UseCaseResult.Error){
                showLoadingDialog.value = false
                alertMessageDeleteLoanFailed.call()
            }
        }
    }

    fun getLoan(id: Int) {
        launch {
            showLoadingDialog.value = true
            val getLoanResult = getLoanUseCase.execute(
                id = id
            )
            if (getLoanResult is UseCaseResult.Success) {
                showLoadingDialog.value = false
                renderLoan.value = getLoanResult.data!!
            } else if (getLoanResult is UseCaseResult.Error){
                showLoadingDialog.value = false
                alertMessageGetLoanFailed.call()
            }
        }
    }

    fun getLoanList() {
        launch {
            showLoadingView.value = true
            val getLoanListResult = getLoanListUseCase.execute()
            if (getLoanListResult is UseCaseResult.Success) {
                showLoadingView.value = false
                renderLoanList.value = getLoanListResult.data!!
            } else if (getLoanListResult is UseCaseResult.Error){
                showLoadingView.value = false
                renderErrorView.call()
            }
        }
    }

    fun getPreviewLoanList(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Float,
        startMonth: Int,
        startYear: Int
    ) {
        launch {
            showLoadingDialog.value = true
            val getReviewLoadListResult = getReviewLoanListUseCase.execute(
                loanAmount = loanAmount,
                loanTerm = loanTerm,
                interestRate = interestRate,
                startMonth = startMonth,
                startYear = startYear
            )
            if (getReviewLoadListResult is UseCaseResult.Success) {
                showLoadingDialog.value = false
                renderReviewLoanList.value = getReviewLoadListResult.data!!
            } else if (getReviewLoadListResult is UseCaseResult.Error){
                showLoadingDialog.value = false
                alertMessageGetReviewLoanFailed.call()
            }
        }
    }

}