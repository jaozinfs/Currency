package com.ineight.repository.local

import com.ineight.persistence.database.RoomBuilder
import com.ineight.repository.Repository
import com.ineight.stuff_lib.domain.User
import com.ineight.stuff_lib.schema.inData
import com.ineight.stuff_lib.schema.toData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class UserRepository(private val roomBuilder: RoomBuilder) : IUserRepository() {
    private val dao = roomBuilder.userDao

    override suspend fun addData(user: User): Long = runBlocking(Dispatchers.IO){
        roomBuilder.clearAllTables()
        dao.insertUser(user.toData())
    }

    override suspend fun updateData(user: User): Int = runBlocking(Dispatchers.IO){
         dao.updateUser(user.toData())
    }


    override suspend fun deleteData(user: User) = withContext(Dispatchers.IO){
        dao.deleteUser(user.toData())
    }

    override suspend fun getData(id: Int): User? = runBlocking(Dispatchers.IO) {
        dao.getUser(id)?.inData()
    }

}