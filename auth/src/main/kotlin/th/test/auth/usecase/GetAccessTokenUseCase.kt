package th.test.auth.usecase

import th.test.auth.data.entity.response.TokenResponse
import th.test.auth.data.repo.AccessTokenRepository
import th.test.core.utils.UseCaseResult

interface GetAccessTokenUseCase {
    fun execute(): UseCaseResult<TokenResponse>
}

class GetAccessTokenUseCaseImpl(
    private val accessTokenRepository: AccessTokenRepository
) : GetAccessTokenUseCase {

    override fun execute(): UseCaseResult<TokenResponse> {
        return try {
            val result = accessTokenRepository.getToken()
            UseCaseResult.Success(result)
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}