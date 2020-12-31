package th.test.auth.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import th.test.auth.data.entity.request.LoginRequest
import th.test.auth.data.entity.request.RefreshTokenRequest
import th.test.auth.data.entity.response.TokenResponse

interface AuthApi {

    @POST("oauth/token")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): TokenResponse

    @POST("oauth/token")
    suspend fun refreshToken(
        @Body refreshTokenRequest: RefreshTokenRequest
    ): TokenResponse

}
