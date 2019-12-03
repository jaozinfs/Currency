package com.ineight.persistence.database.di

import androidx.room.Room
import com.ineight.persistence.database.Constants.RoomName
import com.ineight.persistence.database.RoomBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val roomModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RoomBuilder::class.java,
            RoomName
        ).build()
    }
}