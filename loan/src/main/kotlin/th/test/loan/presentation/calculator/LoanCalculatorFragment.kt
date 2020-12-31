package th.test.loan.presentation.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_loan_calculator.*
import org.koin.android.viewmodel.ext.android.viewModel
import th.test.core.presentation.base.BaseFragment
import th.test.loan.R
import th.test.loan.presentation.adapter.LoanListAdapter

class LoanCalculatorFragment : BaseFragment() {

    companion object {
        const val TAG = "LoanCalculatorFragment"
        fun getNewInstance(): LoanCalculatorFragment = LoanCalculatorFragment()
    }

    private val viewModel: LoanCalculatorViewModel by viewModel()
    private lateinit var loanAdapter: LoanListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loan_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        bindViewModel()
        viewModel.getLoanList()
    }

    private fun initView() {
        loanAdapter = LoanListAdapter()
        loanRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = loanAdapter
        }
    }

    private fun bindViewModel() {
        //Loading view
        viewModel.showLoadingDialog.observe(viewLifecycleOwner, Observer { isShow ->
            if (isShow) {
                showLoading(isCancelable = false)
            } else {
                hideLoading()
            }
        })

        viewModel.showLoadingView.observe(viewLifecycleOwner, Observer { isShow ->
            if (isShow) {
                loadingView.visibility = View.VISIBLE
            } else {
                loadingView.visibility = View.GONE
            }
        })

        //Alert message for success case
        viewModel.alertMessageCreateLoanSuccess.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageUpdateLoanSuccess.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageDeleteLoanSuccess.observe(viewLifecycleOwner, Observer {

        })

        //Alert message for failed case
        viewModel.alertMessageCreateLoanFailed.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageUpdateLoanFailed.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageDeleteLoanFailed.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageGetLoanFailed.observe(viewLifecycleOwner, Observer {

        })

        viewModel.alertMessageGetReviewLoanFailed.observe(viewLifecycleOwner, Observer {

        })

        viewModel.renderErrorView.observe(viewLifecycleOwner, Observer {
            loadingView.visibility = View.GONE
            contentView.visibility = View.GONE
            errorView.visibility = View.VISIBLE
        })

        //Render data
        viewModel.renderLoanList.observe(viewLifecycleOwner, Observer { loanList ->
            loanAdapter.items = loanList
        })

        viewModel.renderLoan.observe(viewLifecycleOwner, Observer { loanData ->

        })

        viewModel.renderReviewLoanList.observe(viewLifecycleOwner, Observer { reviewList ->

        })
    }

}