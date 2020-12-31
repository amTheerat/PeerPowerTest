package th.test.loan.presentation.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import th.test.loan.R

class LoanCalculatorFragment : Fragment() {

    companion object {
        const val TAG = "LoanCalculatorFragment"
        fun getNewInstance(): LoanCalculatorFragment = LoanCalculatorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loan_calculator, container, false)
    }

}