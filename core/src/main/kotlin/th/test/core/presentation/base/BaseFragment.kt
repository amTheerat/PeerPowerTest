package th.test.core.presentation.base

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import th.test.core.navigator.CoreNavigator
import th.test.core.navigator.LoanNavigator
import th.test.core.presentation.dialog.LoadingDialog

abstract class BaseFragment: Fragment() {

    private val coreNavigator: CoreNavigator by inject()

    private var loadingDialog: DialogFragment? = null

    protected fun showSnackBar(message: String, duration: Int) {
        view?.let {
            Snackbar.make(it, message, duration).show()
        }
    }

    protected fun showLoading(isCancelable: Boolean) {
        if (isAdded) {
            activity?.supportFragmentManager?.let { supportFragmentManager ->
                loadingDialog
                    ?.show(supportFragmentManager, LoadingDialog.TAG)
                    ?: kotlin.run {
                        loadingDialog = coreNavigator.getLoadingDialogFragment()
                        loadingDialog?.apply {
                            this.isCancelable = isCancelable
                        }?.show(supportFragmentManager, LoadingDialog.TAG)
                    }
            }
        }
    }

    protected fun hideLoading() {
        if (isAdded) {
            loadingDialog?.dismiss()
        }
    }

}