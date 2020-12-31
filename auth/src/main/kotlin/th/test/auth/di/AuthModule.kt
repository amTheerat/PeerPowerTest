package th.test.auth.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import th.test.auth.data.api.AuthApi
import th.test.auth.data.api.UserApi
import th.test.auth.data.repo.AccessTokenRepository
import th.test.auth.data.repo.AccessTokenRepositoryImpl
import th.test.auth.data.repo.AuthRepository
import th.test.auth.data.repo.AuthRepositoryImpl
import th.test.auth.presentation.login.LoginViewModel
import th.test.auth.usecase.*
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.di.DI_AUTH_RETROFIT

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
}