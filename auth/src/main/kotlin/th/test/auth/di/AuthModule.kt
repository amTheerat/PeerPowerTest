package th.test.auth.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import th.test.auth.data.api.AuthApi
import th.test.auth.data.api.UserApi
import th.test.auth.data.interceptor.AuthHeaderInterceptor
import th.test.auth.data.repo.AccessTokenRepository
import th.test.auth.data.repo.AccessTokenRepositoryImpl
import th.test.auth.data.repo.AuthRepository
import th.test.auth.data.repo.AuthRepositoryImpl
import th.test.auth.presentation.login.LoginViewModel
import th.test.auth.usecase.*
import th.test.core.data.api.BaseOkHttpClientBuilder
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.di.DI_BASE_URL

private const val DI_AUTH_INTERCEPTOR = "DI_AUTH_INTERCEPTOR"
private const val DI_AUTH_OK_HTTP_CLIENT = "DI_AUTH_OK_HTTP_CLIENT"
const val DI_AUTH_RETROFIT = "DI_AUTH_RETROFIT"

val authModule = module {

    //-DI VIEW MODEL BELOW HERE
    viewModel {
        LoginViewModel(
            loginUseCase = get()
        )
    }

    //-DI USECASE BELOW HERE
    factory<CheckLoginUseCase> {
        CheckLoginUseCaseImpl(
            accessTokenRepository = get()
        )
    }

    factory<GetAccessTokenUseCase> {
        GetAccessTokenUseCaseImpl(
            accessTokenRepository = get()
        )
    }

    factory<LoginUseCase> {
        LoginUseCaseImpl(
            authRepository = get(),
            accessTokenRepository = get()
        )
    }

    //-DI REPOSITORY BELOW HERE
    factory<AccessTokenRepository> {
        AccessTokenRepositoryImpl(
            preferenceProvider = get()
        )
    }

    factory<AuthRepository> {
        AuthRepositoryImpl(
            authApi = get()
        )
    }

    //-DI API BELOW HERE
    single<AuthApi> {
        get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build()
    }

    single<UserApi> {
        get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build()
    }

    single(named(DI_AUTH_RETROFIT)) {
        BaseRetrofitBuilder(
            baseOkHttpClintBuilder = get(named(DI_AUTH_OK_HTTP_CLIENT)),
            converterFactory = get(),
            defaultBaseUrl = get(named(DI_BASE_URL))
        )
    }

    single(named(name = DI_AUTH_OK_HTTP_CLIENT)) {
        BaseOkHttpClientBuilder(
            interceptor = arrayOf(get(named(name = DI_AUTH_INTERCEPTOR)))
        ).init()
    }

    single(named(name = DI_AUTH_INTERCEPTOR)) {
        AuthHeaderInterceptor(
            getAccessTokenUseCase = get()
        )
    }
}