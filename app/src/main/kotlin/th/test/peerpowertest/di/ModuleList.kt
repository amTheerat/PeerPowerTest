package th.test.peerpowertest.di

import th.test.auth.di.authModule
import th.test.core.di.coreModule
import th.test.loan.di.loanModule
import th.test.main.di.mainModule

private val featureModules = listOf(
    mainModule,
    authModule,
    loanModule
)

val koinModuleList = listOf(
    coreModule,
    appNavigationModule
) + featureModules