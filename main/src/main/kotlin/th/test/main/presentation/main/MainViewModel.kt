package th.test.main.presentation.main

import th.test.auth.usecase.CheckLoginUseCase
import th.test.core.presentation.base.BaseViewModel
import th.test.core.utils.SingleLiveEvent
import th.test.core.utils.UseCaseResult

class MainViewModel(
    private val checkLoginUseCase: CheckLoginUseCase
): BaseViewModel() {

    val presentLogin = SingleLiveEvent<Unit>()
    val presentLoan = SingleLiveEvent<Unit>()

    fun checkLogin() {
        val checkLoginResult = checkLoginUseCase.execute()
        if (checkLoginResult is UseCaseResult.Complete) {
            presentLoan.call()
        } else {
            presentLogin.call()
        }
    }

}