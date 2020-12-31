package th.test.core.presentation.base

import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment

open class BaseFullScreenDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.apply {
            requestFeature(Window.FEATURE_NO_TITLE)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            val windowLayoutParams = WindowManager.LayoutParams()
            windowLayoutParams.copyFrom(attributes)
            setBackgroundDrawableResource(android.R.color.transparent)
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val display = activity!!.windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            setLayout(width, height)
        }
        val displayRectangle = Rect()
        val window = activity?.window
        window?.decorView?.getWindowVisibleDisplayFrame(displayRectangle)
    }
}