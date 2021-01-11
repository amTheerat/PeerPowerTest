package th.test.auth.usecase

import th.test.auth.data.repo.AccessTokenRepository
import th.test.core.utils.UseCaseResult

interface ClearAccessTokenUseCase {
    fun execute(): UseCaseResult<Nothing>
}

class ClearAccessTokenUseCaseImpl(
    private val accessTokenRepository: AccessTokenRepository
) : ClearAccessTokenUseCase {

    override fun execute(): UseCaseResult<Nothing> {
        return try {
            accessTokenRepository.clearToken()
            UseCaseResult.Complete
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}