package com.ineight.repository

interface Repository<T> {
    suspend fun addData(data: T): Long
    suspend fun updateData(data: T): Int
    suspend fun deleteData(data: T)
    suspend fun getData(id: Int): T?
}