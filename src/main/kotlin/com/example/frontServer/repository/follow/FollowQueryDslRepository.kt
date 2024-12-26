package com.example.frontServer.repository.follow

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.User
import org.springframework.stereotype.Repository

@Repository
interface FollowQueryDslRepository {
    // following Users
    fun findFollowersByUsername(username: String): List<User>

    fun findFollowingsByUserId(username: String): List<User>

    fun findFollowCount(targetUserId: Long): FollowCounts
}