package com.example.frontServer.repository.user

import com.example.frontServer.entity.RedisUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RedisUserRepository: CrudRepository<RedisUser, String> {
    fun findRedisUserByUserId(id: Long): RedisUser?
}