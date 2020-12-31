package th.test.auth.usecase

import th.test.auth.data.entity.request.LoginRequest
import th.test.auth.data.entity.response.TokenResponse
import th.test.auth.data.repo.AccessTokenRepository
import th.test.auth.data.repo.AuthRepository
import th.test.core.CLINT_ID
import th.test.core.CLINT_SECRET
import th.test.core.extension.base64ToPlain
import th.test.core.utils.UseCaseResult
import java.lang.Exception

interface LoginUseCase {
    suspend fun execute(
        username: String,
        password: String
    ): UseCaseResult<TokenResponse>
}

class LoginUseCaseImpl(
    private val authRepository: AuthRepository,
    private val accessTokenRepository: AccessTokenRepository
) : LoginUseCase {

    override suspend fun execute(
        username: String,
        password: String
    ): UseCaseResult<TokenResponse> {
        return try {
            val result = authRepository.login(
                request = LoginRequest(
                    username = username,
                    password = password,
                    client_id = CLINT_ID.base64ToPlain(),
                    client_secret = CLINT_SECRET.base64ToPlain()
                )
            )
            accessTokenRepository.saveToken(token = result)
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}