package com.ineight.domain

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Exception

abstract class UseCase<T, Params>{

    protected abstract suspend fun execute(params: Params): T

    suspend fun doWork(params: Params ) = liveData {
        emit(Result.Loading)
        try{
            withContext(Dispatchers.IO){ delay(1000) }
            emit(Result.Sucess(execute(params)))
        }catch (error: Exception){
            emit(Result.Error(error))
        }
    }
}
