package th.test.main.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import th.test.main.presentation.main.MainViewModel

val mainModule = module {

    //-DI VIEW MODEL BELOW HERE
    viewModel {
        MainViewModel(
            checkLoginUseCase = get()
        )
    }

    //-DI USE CASE BELOW HERE

    //-DI REPOSITORY BELOW HERE

    //-DI API BELOW HERE

}