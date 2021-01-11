package th.test.core.presentation.base

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var toolbarTitleTextView: TextView? = null
    private var toolbarBackImageView: ImageView? = null
    private var navigationView: BottomNavigationView? = null

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

    fun initToolbar(
        toolbarId: Int = 0,
        toolbarTitleTextViewId: Int = 0,
        toolbarBackImageViewId: Int = 0,
        onBackButtonClick: () -> Unit = {}
    ) {
        if (toolbarId > 0) {
            toolbar = findViewById(toolbarId)
            setSupportActionBar(toolbar)
        }

        if (toolbarTitleTextViewId > 0) {
            toolbarTitleTextView = findViewById(toolbarTitleTextViewId)
        }

        if (toolbarBackImageViewId > 0) {
            findViewById<View>(toolbarBackImageViewId)?.setOnClickListener {
                onBackButtonClick.invoke()
            }
            toolbarBackImageView = findViewById(toolbarBackImageViewId)
        }
    }

    fun initBottomView(
        bottomViewId: Int = 0
    ) {
        if (bottomViewId > 0) {
            navigationView = findViewById(bottomViewId)
        }
    }

    fun setToolbarTitle(title: String) {
        toolbarTitleTextView?.text = title
    }

    fun showBackButton() {
        toolbarBackImageView?.visibility = View.VISIBLE
    }

    fun hideBackButton() {
        toolbarBackImageView?.visibility = View.GONE
    }

    fun showBottomNav() {
        navigationView?.visibility = View.VISIBLE
    }

    fun hideBottomNav() {
        navigationView?.visibility = View.GONE
    }

    fun setNavSelectedId(resourceId: Int) {
        navigationView?.selectedItemId = resourceId
    }

    fun replaceFragment(
        fragment: Fragment,
        addToBackStack: Boolean = false,
        containerId: Int = containerResId,
        tag: String? = null
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
        tag: String? = null
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