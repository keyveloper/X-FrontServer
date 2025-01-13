package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy

@Entity
@Table(
    name = "followes",
)
class Follow(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    // follow당하는 타겟
    val followingId: Long,

    // follower 하고 있는 id
    val followerId: Long,

    var isFollow: Boolean,
)