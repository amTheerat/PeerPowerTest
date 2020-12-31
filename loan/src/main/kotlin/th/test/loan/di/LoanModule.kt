package th.test.loan.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.core.di.DI_AUTH_RETROFIT
import th.test.loan.data.api.LoanApi

val loanModule = module {

    //-DI VIEW MODEL BELOW HERE

    //-DI REPOSITORY BELOW HERE

    //-DI API BELOW HERE
    single<LoanApi> { get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build() }
}