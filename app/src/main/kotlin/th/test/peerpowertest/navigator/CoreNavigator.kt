package th.test.peerpowertest.navigator

import androidx.fragment.app.DialogFragment
import th.test.core.navigator.CoreNavigator
import th.test.core.presentation.dialog.LoadingDialog

class CoreNavigatorImpl: CoreNavigator {

    override fun getLoadingDialogFragment(): DialogFragment = LoadingDialog.newInstance()

}