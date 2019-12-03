package com.ineight.domain

import java.lang.Exception

sealed class Result(val data: Any? = null , error: Exception? = null){
    object Loading : Result()
    class Sucess<T>(private val value: T): Result(data = value)
    class Error(val error: Exception): Result(error = error)
}