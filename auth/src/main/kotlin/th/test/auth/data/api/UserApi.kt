package th.test.auth.data.api

import retrofit2.http.GET
import th.test.auth.data.entity.response.UserResponse

interface UserApi {

    @GET("api/user")
    suspend fun getUser(): UserResponse

}
