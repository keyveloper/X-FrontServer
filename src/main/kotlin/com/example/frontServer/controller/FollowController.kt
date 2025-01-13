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
        followService.save(request, user.getUserId())
        // save response modify
        return ResponseEntity.ok().build()
    }
}