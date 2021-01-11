package th.test.peerpowertest.navigator

import androidx.fragment.app.Fragment
import th.test.core.navigator.LoanNavigator
import th.test.loan.presentation.list.MyLoanListFragment

class LoanNavigatorImpl: LoanNavigator {

    override fun getLoanListFragment(): Fragment = MyLoanListFragment.getNewInstance()

}