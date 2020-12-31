package th.test.core.presentation.base

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class BaseActivity : AppCompatActivity() {

    open var containerResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    override fun onBackPressed() {
        finishOrPopBackStack(supportFragmentManager)
    }

    fun replaceFragment(
        fragment: Fragment,
        addToBackStack: Boolean = false,
        containerId: Int = containerResId, tag: String
    ) {
        if (!isFinishing) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(containerId, fragment, tag)

            if (addToBackStack) {
                fragmentTransaction.addToBackStack(tag)
            }
            fragmentTransaction.commit()
        }
    }

    fun addFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        containerId: Int = containerResId,
        tag: String
    ) {
        if (!isFinishing) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(containerId, fragment, tag)
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(tag)
            }
            fragmentTransaction.commit()
        }
    }

    fun clearBackStack() {
        try {
            supportFragmentManager.run {
                if (backStackEntryCount > 0) {
                    for (i in 0 until backStackEntryCount) {
                        popBackStack()
                    }
                }
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    protected fun finishOrPopBackStack(
        fragmentManager: FragmentManager,
        backStackEntryCountLimit: Int = 1
    ): Boolean {
        return if (fragmentManager.backStackEntryCount > backStackEntryCountLimit) {
            fragmentManager.popBackStack()
            false
        } else {
            finish()
            true
        }
    }
}