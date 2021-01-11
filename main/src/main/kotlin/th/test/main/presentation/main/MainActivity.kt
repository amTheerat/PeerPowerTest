package th.test.main.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import th.test.auth.presentation.account.AccountFragment
import th.test.auth.presentation.login.LoginFragment
import th.test.core.navigator.LoanNavigator
import th.test.core.navigator.LoginNavigator
import th.test.core.presentation.base.BaseActivity
import th.test.loan.presentation.list.MyLoanListFragment
import th.test.main.R

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val loginNavigator: LoginNavigator by inject()
    private val loanNavigator: LoanNavigator by inject()

    override var containerResId: Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        bindViewModel()
        viewModel.checkLogin()
    }

    private fun initView() {
        initToolbar(toolbarId = R.id.toolbar,
            toolbarTitleTextViewId = R.id.titleTextView,
            toolbarBackImageViewId = R.id.backImageView,
            onBackButtonClick = {
                onBackPressed()
            })

        initBottomView(
            bottomViewId = R.id.bottomNavigationView
        )

        bottomNavigationView.setOnNavigationItemSelectedListener {
            var value = true
            when (it.itemId) {
                R.id.actionMyLoan -> {
                    renderFragment(tag = MyLoanListFragment.TAG)
                }
                R.id.actionAccount -> {
                    renderFragment(tag = AccountFragment.TAG)
                }
                else -> value = false
            }
            value
        }
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
                fragment = loanNavigator.getLoanListFragment(),
                addToBackStack = true,
                tag = MyLoanListFragment.TAG
            )
        })
    }

    private fun renderFragment(tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val addedFragment = supportFragmentManager.findFragmentByTag(tag)
        if (addedFragment?.isAdded == true) {
            supportFragmentManager.fragments.forEach { fragment ->
                if (fragment.tag == tag) {
                    fragmentTransaction.show(fragment)
                } else {
                    fragmentTransaction.hide(fragment)
                }
            }
            fragmentTransaction.commit()
        } else {
            val newFragment = when (tag) {
                MyLoanListFragment.TAG -> {
                    loanNavigator.getLoanListFragment()
                }
                AccountFragment.TAG -> {
                    loginNavigator.getAccountFragment()
                }
                else -> {
                    null
                }
            }
            newFragment?.let {
                fragmentTransaction.add(containerResId, newFragment, tag)
                fragmentTransaction.addToBackStack(tag)
                fragmentTransaction.commit()
            }
        }
    }

    fun setNavSelectedIndex(position: Int) {
        if (position == 0) {
            bottomNavigationView.selectedItemId = R.id.actionMyLoan
        } else if (position == 1) {
            bottomNavigationView.selectedItemId = R.id.actionAccount
        }
    }
}