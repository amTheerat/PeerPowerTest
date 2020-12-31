package th.test.auth.data.repo

import th.test.auth.data.api.AuthApi
import th.test.auth.data.entity.request.LoginRequest
import th.test.auth.data.entity.request.RefreshTokenRequest
import th.test.auth.data.entity.response.TokenResponse

interface AuthRepository {

    suspend fun login(request: LoginRequest): TokenResponse

    suspend fun refreshToken(request: RefreshTokenRequest): TokenResponse

}

class AuthRepositoryImpl(private val authApi: AuthApi): AuthRepository {

    override suspend fun login(request: LoginRequest): TokenResponse =
        authApi.login(loginRequest = request)

    override suspend fun refreshToken(request: RefreshTokenRequest): TokenResponse =
        authApi.refreshToken(refreshTokenRequest = request)

}