package th.test.core.di

import th.test.core.data.interceptor.BaseInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import th.test.core.DOMAIN_API_URL
import th.test.core.data.api.BaseOkHttpClientBuilder
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.data.api.BaseUrl
import th.test.core.data.interceptor.AuthHeaderInterceptor
import th.test.core.extension.base64ToPlain

private const val DI_BASE_URL = "DI_BASE_URL"
private const val DI_DEFAULT_INTERCEPTOR = "DI_DEFAULT_INTERCEPTOR"
private const val DI_AUTH_INTERCEPTOR = "DI_AUTH_INTERCEPTOR"
private const val DI_AUTH_OK_HTTP_CLIENT = "DI_AUTH_OK_HTTP_CLIENT"
private const val DI_AUTH_RETROFIT = "DI_AUTH_RETROFIT"

val coreModule = module {

    //-DI VIEW MODEL BELOW HERE


    //-DI REPOSITORY BELOW HERE


    //-DI API BELOW HERE
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
        AuthHeaderInterceptor()
    }

    //This interceptor created for request that no need to request with Authorization
    single(named(name = DI_DEFAULT_INTERCEPTOR)) {
        BaseInterceptor()
    }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single(named(name = DI_BASE_URL)) {
        BaseUrl(url = DOMAIN_API_URL.base64ToPlain())
    }
}