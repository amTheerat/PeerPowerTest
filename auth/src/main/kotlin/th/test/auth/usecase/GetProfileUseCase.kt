package th.test.auth.usecase

import th.test.auth.data.entity.model.UserModel
import th.test.auth.data.repo.UserRepository
import th.test.core.utils.UseCaseResult

interface GetProfileUseCase {
    suspend fun execute(): UseCaseResult<UserModel>
}

class GetProfileUseCaseImpl(
    private val userRepository: UserRepository
) : GetProfileUseCase {

    override suspend fun execute(): UseCaseResult<UserModel> {
        return try {
            UseCaseResult.Success(userRepository.getUser())
        } catch (e: Exception) {
            UseCaseResult.Error(e)
        }
    }

}