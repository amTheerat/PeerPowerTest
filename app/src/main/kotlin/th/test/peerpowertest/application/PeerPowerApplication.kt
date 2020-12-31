package th.test.peerpowertest.application

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import th.test.peerpowertest.BuildConfig
import th.test.peerpowertest.di.koinModuleList

class PeerPowerApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) {
                printLogger()
            }
            androidContext(this@PeerPowerApplication)
            modules(koinModuleList)
        }
    }

}