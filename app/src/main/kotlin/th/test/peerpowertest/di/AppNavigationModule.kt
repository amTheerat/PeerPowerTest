package th.test.peerpowertest.di

import org.koin.dsl.module
import th.test.core.navigator.LoanNavigator
import th.test.peerpowertest.navigator.LoanNavigatorImpl

val appNavigationModule = module {

    single<LoanNavigator> {
        LoanNavigatorImpl()
    }

}