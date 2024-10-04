package com.example.frontServer.entity

import java.io.Serializable

data class UserRoleId(
    val user: Long? = null,
    var role: Long? = null
) : Serializable