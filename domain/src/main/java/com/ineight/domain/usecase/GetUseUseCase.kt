package com.ineight.domain.usecase

import com.ineight.domain.UseCase

import com.ineight.repository.local.IUserRepository
import com.ineight.stuff_lib.domain.User

class GetUseUseCase( private val userRepository: IUserRepository ) :
    UseCase<User?, GetUseUseCase.Params>() {

    override suspend fun execute(params: Params): User?
            = userRepository.getData(params.id)

    suspend fun getUser(params: Params) = doWork(params = params)

    data class Params(val id: Int)
}