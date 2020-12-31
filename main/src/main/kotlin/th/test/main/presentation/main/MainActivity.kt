package th.test.main.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import th.test.auth.presentation.login.LoginFragment
import th.test.core.navigator.LoanNavigator
import th.test.core.navigator.LoginNavigator
import th.test.core.presentation.base.BaseActivity
import th.test.loan.presentation.calculator.LoanCalculatorFragment
import th.test.main.R

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val loginNavigator: LoginNavigator by inject()
    private val loanNavigator: LoanNavigator by inject()

    override var containerResId: Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViewModel()
        viewModel.checkLogin()
    }

    private fun bindViewModel() {
        viewModel.presentLogin.observe(this, Observer {
            addFragment(
                fragment = loginNavigator.getLoginFragment(),
                addToBackStack = true,
                tag = LoginFragment.TAG
            )
        })

        viewModel.presentLoan.observe(this, Observer {
            addFragment(
                fragment = loanNavigator.getLoanCalculatorFragment(),
                addToBackStack = true,
                tag = LoanCalculatorFragment.TAG
            )
        })
    }
}