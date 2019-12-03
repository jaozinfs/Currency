package com.ineight.stuff_lib.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey val id: Int? = null, val name: String, val email: String)