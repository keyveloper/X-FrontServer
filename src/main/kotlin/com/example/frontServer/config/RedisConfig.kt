package com.example.frontServer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
@EnableRedisRepositories
class RedisConfig {

    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(connectionFactory)

        // StringRedisSerializer, GenerickJackson2JsonRedisSerializer 사용
        val keySerializer: RedisSerializer<String> = StringRedisSerializer()
        val valueSerializer = GenericJackson2JsonRedisSerializer()

        template.keySerializer = keySerializer
        template.valueSerializer = valueSerializer
        template.hashKeySerializer = keySerializer
        template.hashValueSerializer = valueSerializer

        template.afterPropertiesSet()
        return template
    }
}