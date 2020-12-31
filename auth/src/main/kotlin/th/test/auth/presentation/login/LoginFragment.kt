package th.test.auth.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel
import th.test.auth.R
import th.test.core.presentation.base.BaseFragment

class LoginFragment : BaseFragment() {

    companion object {
        const val TAG = "LoginFragment"
        fun getNewInstance(): LoginFragment = LoginFragment()
    }

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        bindViewModel()
    }

    private fun initView() {
        loginButton.setOnClickListener {
            loginViewModel.login(
                username = "bob@peerpower.co.th",
                password = "1"
            )
        }
    }

    private fun bindViewModel() {
        loginViewModel.showLoading.observe(viewLifecycleOwner, Observer { showLoading ->
            if (showLoading) {
                showLoading(isCancelable = true)
            } else {
                hideLoading()
            }
        })

        loginViewModel.presentNext.observe(viewLifecycleOwner, Observer {

        })

        loginViewModel.alertLoginFailed.observe(viewLifecycleOwner, Observer { errorMessage ->
            showSnackBar(
                message = errorMessage,
                duration = Snackbar.LENGTH_LONG
            )
        })
    }
}