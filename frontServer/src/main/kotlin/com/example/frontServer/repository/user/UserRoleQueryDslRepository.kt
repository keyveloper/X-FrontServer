package com.example.frontServer.repository.user

import com.example.frontServer.entity.Role

interface UserRoleQueryDslRepository {
    fun findRolesByUsername(username: String): List<Role>
}