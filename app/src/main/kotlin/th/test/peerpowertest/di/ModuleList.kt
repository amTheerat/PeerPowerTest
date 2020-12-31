package th.test.peerpowertest.di

import th.test.core.di.coreModule
import th.test.main.di.mainModule

private val featureModules = listOf(
    mainModule
)

val koinModuleList = listOf(
    coreModule,
    appNavigationModule
) + featureModules