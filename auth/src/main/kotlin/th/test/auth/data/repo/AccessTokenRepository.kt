package th.test.auth.data.repo

import com.google.gson.Gson
import th.test.auth.data.entity.response.TokenResponse
import th.test.core.provider.PreferenceProvider

interface AccessTokenRepository {
    fun getToken(): TokenResponse
    fun saveToken(token: TokenResponse)
    fun clearToken()
}

class AccessTokenRepositoryImpl(
    private val preferenceProvider: PreferenceProvider
): AccessTokenRepository {

    companion object {
        private val PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN"
    }

    override fun getToken(): TokenResponse {
        val jsonString = preferenceProvider.getPreference(
            key = PREF_ACCESS_TOKEN,
            defValue = ""
        )
        return Gson().fromJson(jsonString, TokenResponse::class.java)
    }

    override fun saveToken(token: TokenResponse) {
        preferenceProvider.setPreference(
            key = PREF_ACCESS_TOKEN,
            value = Gson().toJson(token)
        )
    }

    override fun clearToken() = preferenceProvider.clearPreference(PREF_ACCESS_TOKEN)
}