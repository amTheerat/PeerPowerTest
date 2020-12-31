package th.test.core.presentation.base

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment: Fragment() {

    protected fun showSnackBar(message: String, duration: Int) {
        view?.let {
            Snackbar.make(it, message, duration).show()
        }
    }

}