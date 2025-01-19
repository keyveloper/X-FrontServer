package com.example.frontServer.dto.user.response

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.RedisUser
import com.example.frontServer.entity.User
import java.time.LocalDate
import java.time.LocalDateTime

data class UserProfileGetResult(
    val id: Long,
    val username: String,
    val email: String,
    val profileImgUrl: String?,
    val introduction: String?,
    val birthday: LocalDate?,
    val country: String?,
    val firstMadeDate: LocalDateTime,
    val followingCount: Long,
    val followerCount: Long
    ) {
    companion object {
        fun of(user: User, followCounts: FollowCounts): UserProfileGetResult {
            return UserProfileGetResult(
                id = user.id!!,
                username = user.username,
                email = user.email,
                profileImgUrl = user.userImg,
                introduction = user.introduction,
                birthday = user.birthday,
                country = user.country,
                firstMadeDate = user.firstMadeDate!!,
                followingCount = followCounts.followingCount,
                followerCount = followCounts.followerCount
            )
        }

        fun of(redisUser: RedisUser): UserProfileGetResult {
            return UserProfileGetResult(
                id = redisUser.userId,
                username = redisUser.username,
                email = redisUser.email,
                profileImgUrl = redisUser.userImg,
                introduction = redisUser.introduction,
                birthday = redisUser.birthday,
                country = redisUser.country,
                firstMadeDate = redisUser.firstMadeDate,
                followingCount = redisUser.followingCount,
                followerCount = redisUser.followerCount
            )
        }
    }

}