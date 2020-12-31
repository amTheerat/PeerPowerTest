package th.test.core.di

import org.koin.android.ext.koin.androidContext
import th.test.core.data.interceptor.BaseInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory
import th.test.core.DOMAIN_API_URL
import th.test.core.data.api.BaseOkHttpClientBuilder
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.data.api.BaseUrl
import th.test.core.extension.base64ToPlain
import th.test.core.provider.PreferenceProvider
import th.test.core.provider.SharedPreferenceProvider

const val DI_BASE_URL = "DI_BASE_URL"
const val DI_DEFAULT_INTERCEPTOR = "DI_DEFAULT_INTERCEPTOR"

val coreModule = module {

    //-DI VIEW MODEL BELOW HERE


    //-DI REPOSITORY BELOW HERE


    //-DI API BELOW HERE
    //This interceptor created for request that no need to request with Authorization
    single(named(name = DI_DEFAULT_INTERCEPTOR)) {
        BaseInterceptor()
    }

    single<Converter.Factory> {
        GsonConverterFactory.create()
    }

    single<PreferenceProvider> {
        SharedPreferenceProvider(androidContext())
    }

    single(named(name = DI_BASE_URL)) {
        BaseUrl(url = DOMAIN_API_URL.base64ToPlain())
    }
}