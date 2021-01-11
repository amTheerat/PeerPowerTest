package th.test.auth.presentation.account

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import th.test.auth.usecase.ClearAccessTokenUseCase
import th.test.auth.usecase.GetProfileUseCase
import th.test.auth.usecase.LoginUseCase
import th.test.core.presentation.base.BaseViewModel
import th.test.core.utils.SingleLiveEvent
import th.test.core.utils.UseCaseResult

class AccountViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val clearAccessTokenUseCase: ClearAccessTokenUseCase
) : BaseViewModel() {

    val showLoading = SingleLiveEvent<Boolean>()
    val presentLogin = SingleLiveEvent<Unit>()

    val renderName = MutableLiveData<String>()
    val renderEmail = MutableLiveData<String>()
    val alertGetProfileFailed = SingleLiveEvent<Unit>()

    fun loadProfile() {
        launch {
            showLoading.value = true
            val loadProfileResult = getProfileUseCase.execute()
            if (loadProfileResult is UseCaseResult.Success) {
                renderName.value = loadProfileResult.data!!.name
                renderEmail.value = loadProfileResult.data!!.email
                showLoading.value = false
            } else if (loadProfileResult is UseCaseResult.Error) {
                showLoading.value = false
                alertGetProfileFailed.call()
            }
        }
    }

    fun logout() {
        val clearAccessTokenUseCase = clearAccessTokenUseCase.execute()
        if (clearAccessTokenUseCase is UseCaseResult.Complete) {
            presentLogin.call()
        }
    }

}