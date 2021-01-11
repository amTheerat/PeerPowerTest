package th.test.peerpowertest.navigator

import androidx.fragment.app.Fragment
import th.test.auth.presentation.account.AccountFragment
import th.test.auth.presentation.login.LoginFragment
import th.test.core.navigator.LoginNavigator

class LoginNavigatorImpl: LoginNavigator {

    override fun getLoginFragment(): Fragment = LoginFragment.getNewInstance()

    override fun getAccountFragment(): Fragment = AccountFragment.getNewInstance()

}
