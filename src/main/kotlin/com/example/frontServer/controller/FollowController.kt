package com.example.frontServer.controller

import com.example.frontServer.dto.follow.FollowSaveRequest
import com.example.frontServer.dto.user.UserSummaryDto
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.follow.FollowService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
class FollowController(
    private val followService: FollowService
) {

    @PostMapping("/follow")
    fun save(
        @RequestBody request: FollowSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<Void> {
        followService.save(request.followingName, user.getUserId())
        // save response modify
        return ResponseEntity.ok().build()
    }

    @GetMapping("/following/users")
    fun findFollowingUsers(
        @RequestParam username: String
    ): ResponseEntity<List<UserSummaryDto>> {
        val followingSummaries: List<UserSummaryDto> =
            followService.findFollowings(username)

        return ResponseEntity.ok().body(followingSummaries)
    }

    @GetMapping("/follower/users")
    fun findFollowerUsers(
        @RequestParam username: String
    ): ResponseEntity<List<UserSummaryDto>> {

        val followerSummaries: List<UserSummaryDto>? =
            followService.findFollowers(username)
        if (followerSummaries == null) {
            return ResponseEntity.badRequest().body(null)
        }

        return ResponseEntity.ok().body(followerSummaries)
    }
}