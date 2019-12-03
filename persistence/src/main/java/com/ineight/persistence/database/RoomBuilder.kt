package com.ineight.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ineight.persistence.database.Constants.RoomVersion
import com.ineight.persistence.database.dao.UserDao
import com.ineight.stuff_lib.entity.UserEntity

@Database(entities = [UserEntity::class], version = RoomVersion)
abstract class RoomBuilder : RoomDatabase() {
    abstract val userDao: UserDao

    override fun clearAllTables() {
        clearAllTables()
    }

}
