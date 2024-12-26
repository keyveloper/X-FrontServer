package com.example.frontServer.controller.api

import com.example.frontServer.dto.timeline.response.TimelineBoardResponse
import com.example.frontServer.dto.timeline.request.TimelineGetRequest
import com.example.frontServer.service.timeline.TimelineBoardService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TimelineBoardController(
    // timeline service + board service
    private val timelineBoardService: TimelineBoardService
) {
    @PostMapping("/getTimeline/init")
    fun findTimelineInit(
        @Valid @RequestBody request: TimelineGetRequest
    ) {

    }

    // timeline용 -> 옮기기
    @PostMapping("/getTimeline/next")
    fun findTimelineNext(
        @RequestBody timelineRequest: TimelineGetRequest
    ): ResponseEntity<List<TimelineBoardResponse>> {
        return ResponseEntity.ok().body(

        )
    }

    @PostMapping("/getTimeline/prev")
    fun findTimelineBefore(
        @RequestBody timelineRequest: TimelineGetRequest
    ): ResponseEntity<List<TimelineBoardResponse>> {
        return ResponseEntity.ok().body(

        )
    }


}