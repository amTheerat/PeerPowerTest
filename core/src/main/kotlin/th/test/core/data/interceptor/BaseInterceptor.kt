package th.test.core.data.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

open class BaseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val mapHeader = mutableMapOf<String, String>()
        addHeaders(mapHeader)
        val request = createRequestHeader(chain = chain, mapHeader = mapHeader)
        return chain.proceed(request)
    }

    private fun createRequestHeader(chain: Interceptor.Chain, mapHeader: Map<String, String>): Request {
        val request = chain.request().newBuilder()
        for (key in mapHeader.keys) {
            request.addHeader(key, mapHeader[key] ?: error(""))
        }
        return request.build()
    }

    open fun addHeaders(mapHeader: MutableMap<String, String>) {
        //Add commond header params here
        mapHeader["X-Requested-With"] = "XMLHttpRequest"
        mapHeader["Accept"] = "application/json"
    }
}