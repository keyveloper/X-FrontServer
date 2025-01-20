package com.example.frontServer.entity

import com.example.frontServer.dto.user.response.UserProfileGetResult
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.time.LocalDateTime

@RedisHash("users")
class RedisUser(
    @Id
    val userId: Long,

    val username: String,

    val email: String,

    val userImg: String?,

    val introduction: String?,

    val birthday: LocalDate?,

    val firstMadeDate: LocalDateTime,

    val country: String?,

    val followingCount: Long,

    val followerCount: Long
    ) {
    companion object {
        fun of(profileGetResult: UserProfileGetResult): RedisUser {
            return RedisUser(
                userId = profileGetResult.id,
                username = profileGetResult.username,
                email = profileGetResult.email,
                userImg = profileGetResult.profileImgUrl,
                introduction = profileGetResult.introduction,
                birthday = profileGetResult.birthday,
                firstMadeDate = profileGetResult.firstMadeDate,
                country = profileGetResult.country,
                followerCount = profileGetResult.followerCount,
                followingCount = profileGetResult.followingCount,
            )
        }
    }
}