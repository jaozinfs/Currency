package com.ineight.home.ui

import android.os.Bundle
import com.ineight.common.base.BaseActivity
import com.ineight.home.R

class HomeActivity : BaseActivity() {
    override fun showProgress(visibility: Boolean) {
        //..
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
