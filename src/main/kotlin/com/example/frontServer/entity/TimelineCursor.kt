package com.example.frontServer.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "timeline_cursors"
)
class TimelineCursor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    val receiverId: Long,

    val lastSeenId: Long,
    )