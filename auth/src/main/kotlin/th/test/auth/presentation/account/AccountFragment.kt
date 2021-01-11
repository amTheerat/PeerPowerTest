package th.test.auth.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_account.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import th.test.auth.R
import th.test.auth.presentation.login.LoginFragment
import th.test.core.navigator.LoginNavigator
import th.test.core.presentation.base.BaseActivity
import th.test.core.presentation.base.BaseFragment

class AccountFragment : BaseFragment() {

    companion object {
        const val TAG = "AccountFragment"
        fun getNewInstance(): AccountFragment = AccountFragment()
    }

    private val accountViewModel: AccountViewModel by viewModel()
    private val loginNavigator: LoginNavigator by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        bindViewModel()
        accountViewModel.loadProfile()
    }

    private fun initView() {
        (activity as? BaseActivity)?.apply {
            setToolbarTitle(getString(R.string.account))
            hideBackButton()
            showBottomNav()
        }

        logoutButton.setOnClickListener {
            accountViewModel.logout()
        }
    }

    private fun bindViewModel() {
        accountViewModel.showLoading.observe(viewLifecycleOwner, Observer { isShow ->
            if (isShow) {
                loadingView.visibility = View.VISIBLE
            } else {
                loadingView.visibility = View.GONE
            }
        })

        accountViewModel.renderName.observe(viewLifecycleOwner, Observer {
            nameTextView.text = it
        })

        accountViewModel.renderEmail.observe(viewLifecycleOwner, Observer {
            emailTextView.text = it
        })

        accountViewModel.alertGetProfileFailed.observe(viewLifecycleOwner, Observer {
            showSnackBar(getString(R.string.failed_to_load_profile), Snackbar.LENGTH_SHORT)
        })

        accountViewModel.presentLogin.observe(viewLifecycleOwner, Observer {
            (activity as BaseActivity).apply {
                clearBackStack()
                addFragment(
                    fragment = loginNavigator.getLoginFragment(),
                    addToBackStack = true,
                    tag = LoginFragment.TAG
                )
            }
        })
    }
}