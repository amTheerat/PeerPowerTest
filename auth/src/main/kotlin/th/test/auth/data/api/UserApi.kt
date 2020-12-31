package th.test.auth.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import th.test.auth.data.entity.request.RefreshTokenRequest
import th.test.auth.data.entity.response.UserResponse

interface UserApi {

    @GET("api/user")
    suspend fun getUser(
        @Body refreshTokenRequest: RefreshTokenRequest
    ): UserResponse

}
