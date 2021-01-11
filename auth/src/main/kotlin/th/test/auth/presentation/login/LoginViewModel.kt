package th.test.auth.presentation.login

import kotlinx.coroutines.launch
import th.test.auth.usecase.LoginUseCase
import th.test.core.presentation.base.BaseViewModel
import th.test.core.utils.SingleLiveEvent
import th.test.core.utils.UseCaseResult

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    val showLoading = SingleLiveEvent<Boolean>()
    val presentNext = SingleLiveEvent<Unit>()

    val alertLoginFailed = SingleLiveEvent<Unit>()

    fun login(
        username: String,
        password: String
    ) {
        launch {
            showLoading.value = true
            val loginResult = loginUseCase.execute(
                username = username,
                password = password
            )
            if (loginResult is UseCaseResult.Success) {
                showLoading.value = false
                presentNext.call()
            } else if (loginResult is UseCaseResult.Error) {
                showLoading.value = false
                loginResult.exception.message?.let { errorMessage ->
                    alertLoginFailed.call()
                }
            }
        }
    }

}