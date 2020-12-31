package th.test.peerpowertest.navigator

import androidx.fragment.app.Fragment
import th.test.core.navigator.LoanNavigator
import th.test.loan.presentation.calculator.LoanCalculatorFragment

class LoanNavigatorImpl: LoanNavigator {

    override fun getLoanCalculatorFragment(): Fragment = LoanCalculatorFragment.getNewInstance()

}