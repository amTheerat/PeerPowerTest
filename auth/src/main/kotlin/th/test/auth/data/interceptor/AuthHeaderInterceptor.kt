package th.test.auth.data.interceptor

import th.test.auth.usecase.GetAccessTokenUseCase
import th.test.core.data.interceptor.BaseInterceptor
import th.test.core.extension.base64ToPlain
import th.test.core.utils.UseCaseResult

open class AuthHeaderInterceptor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
): BaseInterceptor() {

    companion object {
        const val AUTHORIZATION_HEADER = "QXV0aG9yaXphdGlvbg=="
    }

    override fun addHeaders(mapHeader: MutableMap<String, String>) {
        super.addHeaders(mapHeader)
        val getAccessTokenResult = getAccessTokenUseCase.execute()
        if (getAccessTokenResult is UseCaseResult.Success) {
            mapHeader[AUTHORIZATION_HEADER.base64ToPlain()] = getAccessTokenResult
                .data
                ?.token_type
                .plus(" ")
                .plus(getAccessTokenResult.data?.access_token)
        }
    }
}