package com.ineight.stuff_lib.schema

import com.ineight.stuff_lib.domain.User
import com.ineight.stuff_lib.entity.UserEntity

fun User.toData() =
    UserEntity(name = name, email = email)
fun UserEntity.inData() =
    User(id = id, name = name, email = email)