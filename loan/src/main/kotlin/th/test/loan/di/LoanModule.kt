package th.test.loan.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import th.test.auth.di.DI_AUTH_RETROFIT
import th.test.core.data.api.BaseRetrofitBuilder
import th.test.loan.data.api.LoanApi
import th.test.loan.data.repo.LoanRepository
import th.test.loan.data.repo.LoanRepositoryImpl
import th.test.loan.presentation.calculator.LoanCalculatorViewModel
import th.test.loan.usecase.*

val loanModule = module {

    //-DI VIEW MODEL BELOW HERE
    viewModel {
        LoanCalculatorViewModel(
            createLoanUseCase = get(),
            deleteLoanUseCase = get(),
            getLoanListUseCase = get(),
            getLoanUseCase = get(),
            getReviewLoanListUseCase = get(),
            updateLoanUseCase = get()
        )
    }

    //-DI USE CASE BELOW HERE
    factory<CreateLoanUseCase> {
        CreateLoanUseCaseImpl(
            loanRepository = get()
        )
    }

    factory<DeleteLoanUseCase> {
        DeleteLoanUseCaseImpl(
            loanRepository = get()
        )
    }

    factory<GetLoanListUseCase> {
        GetLoanListUseCaseImpl(
            loanRepository = get()
        )
    }

    factory<GetLoanUseCase> {
        GetLoanUseCaseImpl(
            loanRepository = get()
        )
    }

    factory<GetReviewLoanListUseCase> {
        GetReviewLoanListUseCaseImpl(
            loanRepository = get()
        )
    }

    factory<UpdateLoanUseCase> {
        UpdateLoanUseCaseImpl(
            loanRepository = get()
        )
    }

    //-DI REPOSITORY BELOW HERE
    factory<LoanRepository> {
        LoanRepositoryImpl(
            loanApi = get()
        )
    }

    //-DI API BELOW HERE
    single<LoanApi> {
        get<BaseRetrofitBuilder>(named(DI_AUTH_RETROFIT)).build()
    }

}