package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "boards")
@EntityListeners(AuditingEntityListener::class)
class Board (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    val writerId : Long,

    var textContent: String,

    var fileApiUrl: String?, // api url

    @CreatedDate
    var createdAt: LocalDateTime?,

    @LastModifiedDate
    var lastModifiedAt: LocalDateTime?,

    var readingCount : Long,

    var parentId: Long?,

    var invalid: Boolean,
    )