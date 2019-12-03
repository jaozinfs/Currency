package com.ineight.domain.usecase

import com.ineight.domain.UseCase

import com.ineight.repository.local.IUserRepository
import com.ineight.stuff_lib.domain.User

class InsertUserUseCase(private val userRepository: IUserRepository ) :
    UseCase<Long?, InsertUserUseCase.Params>() {

    override suspend fun execute(params: Params): Long?
            = userRepository.addData(User(name = params.name, email = params.email))

    suspend fun insert(params: Params) = doWork(params = params)

    data class Params(val name: String, val email: String)

}