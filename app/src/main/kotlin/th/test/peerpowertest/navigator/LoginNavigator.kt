package th.test.peerpowertest.navigator

import androidx.fragment.app.Fragment
import th.test.auth.presentation.login.LoginFragment
import th.test.core.navigator.LoanNavigator
import th.test.core.navigator.LoginNavigator
import th.test.loan.presentation.calculator.LoanCalculatorFragment

class LoginNavigatorImpl: LoginNavigator {

    override fun getLoginFragment(): Fragment = LoginFragment.getNewInstance()

}