package com.example.frontServer.service.user

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.service.follow.FollowService
import org.springframework.stereotype.Service

@Service
class UserFollowService(
    private val followerService: FollowService
) {
    fun findFollowCount(id: Long): FollowCounts {
        return followerService.findFollowCounts(id)
    }
}