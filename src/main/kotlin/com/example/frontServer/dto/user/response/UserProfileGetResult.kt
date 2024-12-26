package com.example.frontServer.dto.user.response

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.User
import java.time.LocalDate
import java.time.LocalDateTime

data class UserProfileGetResult(
    val email: String?,
    val username: String,
    val id: Long,
    val introduction: String?,
    val birthday: LocalDate?,
    val firstMadeDate: LocalDateTime,
    val followingCount: Long,
    val followerCount: Long
    ) {
    companion object {
        fun of(user: User, followCounts: FollowCounts): UserProfileGetResult {
            return UserProfileGetResult(
                email = user.email,
                username = user.username,
                id = user.id!!,
                introduction = user.introduction,
                birthday = user.birthday,
                firstMadeDate = user.firstMadeDate!!,
                followingCount = followCounts.followingCount,
                followerCount = followCounts.followerCount
            )
        }
    }

}