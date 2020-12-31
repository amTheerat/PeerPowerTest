package th.test.main.presentation.main

import android.os.Bundle
import th.test.core.presentation.base.BaseActivity
import th.test.main.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}