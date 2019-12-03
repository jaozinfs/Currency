package com.ineight.persistence.database.dao

import androidx.room.*
import com.ineight.stuff_lib.entity.UserEntity


@Dao
interface UserDao{

    @Insert
    fun insertUser(userEntity: UserEntity): Long

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity): Int


    @Query("SELECT * FROM userentity WHERE id LIKE :id LIMIT 1")
    fun getUser(id: Int): UserEntity?
}