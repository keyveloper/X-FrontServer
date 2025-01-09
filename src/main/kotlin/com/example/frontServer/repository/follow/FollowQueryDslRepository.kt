package com.example.frontServer.repository.follow

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.Follow
import org.springframework.stereotype.Repository

@Repository
interface FollowQueryDslRepository {
    fun findFollowCounts(targetUserId: Long): FollowCounts

    fun findFollowersById(targetUserId: Long): List<Follow>
}