package th.test.auth.data.repo

import th.test.auth.data.api.UserApi
import th.test.auth.data.entity.model.UserModel

interface UserRepository {

    suspend fun getUser(): UserModel

}

class UserRepositoryImpl(private val userApi: UserApi): UserRepository {

    override suspend fun getUser(): UserModel = userApi.getUser().data

}