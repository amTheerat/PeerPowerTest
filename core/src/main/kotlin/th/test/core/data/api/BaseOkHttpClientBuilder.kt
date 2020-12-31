package th.test.core.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import java.util.concurrent.TimeUnit

class BaseOkHttpClientBuilder(private vararg val interceptor: Interceptor) {

    fun init(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
            .connectTimeout(HTTP_TIMEOUT_SECOND, TimeUnit.SECONDS)
            .apply {
                interceptor.forEach { interceptor ->
                    this.addInterceptor(interceptor)
                }

                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    addInterceptor(logging)
                }
            }
    }
}