package com.example.frontServer.controller

import com.example.frontServer.dto.timeline.TimelineResponse
import com.example.frontServer.service.TimelineService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TimelineController(
    private val timelineService: TimelineService
) {
   @GetMapping("/timeline")
   fun findAllByReceiverId(
       @RequestBody receiverId: Long
   ): ResponseEntity<List<TimelineResponse>> {
       val timelineResults = timelineService.findByReceiverId(receiverId)
       return ResponseEntity.ok().body(
           timelineResults.map {
               TimelineResponse(it, null)
           }
       )
   }
}