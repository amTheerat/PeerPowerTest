package th.test.peerpowertest.di

import org.koin.dsl.module
import th.test.core.navigator.CoreNavigator
import th.test.core.navigator.LoanNavigator
import th.test.core.navigator.LoginNavigator
import th.test.peerpowertest.navigator.CoreNavigatorImpl
import th.test.peerpowertest.navigator.LoanNavigatorImpl
import th.test.peerpowertest.navigator.LoginNavigatorImpl

val appNavigationModule = module {

    single<CoreNavigator> {
        CoreNavigatorImpl()
    }

    single<LoginNavigator> {
        LoginNavigatorImpl()
    }

    single<LoanNavigator> {
        LoanNavigatorImpl()
    }

}