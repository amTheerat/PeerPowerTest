package th.test.core.data.interceptor

open class AuthHeaderInterceptor: BaseInterceptor() {

    companion object {
        const val AUTHORIZATION_HEADER = "QXV0aG9yaXphdGlvbg=="
    }

    override fun addHeaders(mapHeader: MutableMap<String, String>) {
        super.addHeaders(mapHeader)

    }
}