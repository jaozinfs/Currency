package com.ineight.router

import com.ineight.router.Constants.HOME
import com.ineight.router.Constants.LOGIN
import com.ineight.router.di.LoginModules
import org.koin.core.module.Module

enum class Features(val `package`: String, val modules: List<Module>) {
    Login(LOGIN, LoginModules.loginModules),
    Home(HOME, emptyList())
}