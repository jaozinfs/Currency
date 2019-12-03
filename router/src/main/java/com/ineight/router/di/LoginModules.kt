package com.ineight.router.di

import com.ineight.domain.usecase.GetUseUseCase
import com.ineight.domain.usecase.InsertUserUseCase
import com.ineight.repository.local.IUserRepository
import com.ineight.repository.local.UserRepository
import org.koin.dsl.module

object LoginModules {
    val loginModules = listOf(domainModules)
}
internal val domainModules = module{
    factory {
        UserRepository(get()) as IUserRepository
    }
    factory {
        GetUseUseCase(get())
        InsertUserUseCase(get())
    }
}