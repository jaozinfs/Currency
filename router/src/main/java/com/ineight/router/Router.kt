package com.ineight.router

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import org.koin.core.context.loadKoinModules
import org.koin.dsl.koinApplication

/**
 * Start one feature from enum of features
 * @param features
 */
var feature: Features = Features.Home

fun AppCompatActivity.goTo(features: Features): Intent?{

    //assert that feature not same
    if(feature == features)return null

    //unload preview fueature mudles
    koinApplication { unloadModules(feature.modules) }

    //save feature
    feature = features

    //load modules
    koinApplication { loadKoinModules(features.modules) }


    val basePath = "com.ineight"
    val clazz = Class.forName(basePath.plus("com.ineight.login.LoginActivity")).name
    return Intent().apply {
        action = Intent.ACTION_VIEW
        setClassName(packageName, "com.ineight.login.LoginActivity")
    }

}
