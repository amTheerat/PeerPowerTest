package th.test.auth.usecase

import th.test.auth.data.repo.AccessTokenRepository
import th.test.core.utils.UseCaseResult

interface CheckLoginUseCase {
    fun execute(): UseCaseResult<Nothing>
}

class CheckLoginUseCaseImpl(
    private val accessTokenRepository: AccessTokenRepository
) : CheckLoginUseCase {

    override fun execute(): UseCaseResult<Nothing> {
        return try {
            val result = accessTokenRepository.getToken()
            if (result.access_token.isEmpty() && result.access_token.isEmpty()) {
                UseCaseResult.Error(Throwable("HAVE NO LOGIN"))
            } else {
                UseCaseResult.Complete
            }
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}