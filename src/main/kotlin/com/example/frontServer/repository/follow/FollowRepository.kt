package com.example.frontServer.repository.follow

import com.example.frontServer.entity.Follow
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FollowRepository: JpaRepository<Follow, Long>, FollowQueryDslRepository {
    fun findByFollowingIdAndFollowerId(followingId: Long, followerId: Long): Optional<Follow>
}