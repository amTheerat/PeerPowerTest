package th.test.auth.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import th.test.auth.data.api.AuthApi
import th.test.auth.data.api.UserApi
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.di.DI_AUTH_RETROFIT

val authModule = module {

    //-DI VIEW MODEL BELOW HERE

    //-DI REPOSITORY BELOW HERE

    //-DI API BELOW HERE
    single<AuthApi> { get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build() }

    single<UserApi> { get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build() }
}