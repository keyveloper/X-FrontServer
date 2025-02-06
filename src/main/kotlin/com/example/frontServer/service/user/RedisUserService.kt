package com.example.frontServer.service.user

import com.example.frontServer.dto.user.response.UserProfileGetResult
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisUserService(
    private val objectMapper: ObjectMapper,
    private val redisTemplate: RedisTemplate<String, String>
) {
    private val logger = KotlinLogging.logger {}

    fun save(redisDto: UserProfileGetResult) {
        val json = objectMapper.writeValueAsString(redisDto)
        redisTemplate.opsForValue().set("user:profile:${redisDto.id}", json)
    }

    fun findByUserId(userId: Long): UserProfileGetResult? {
        val key = "user:profile:${userId}"
        val json: String? = redisTemplate.opsForValue().get(key)

        return json?.let {
            objectMapper.readValue(it, UserProfileGetResult::class.java)
        }?: run {
            logger.error { "can't find user- id: $userId" }
            null
        }
    }
}