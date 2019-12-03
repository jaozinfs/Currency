package com.ineight.common.base

import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {


    abstract fun showProgress(visibility: Boolean)

}