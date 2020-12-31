package th.test.core.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import th.test.core.R
import th.test.core.presentation.base.BaseFullScreenDialog

class LoadingDialog : BaseFullScreenDialog() {
    companion object {
        val TAG = "LoadingDialog"
        fun newInstance(): LoadingDialog = LoadingDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.dialog_loading, container, false)
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            setBackgroundDrawableResource(R.color.white70)
        }
    }
}