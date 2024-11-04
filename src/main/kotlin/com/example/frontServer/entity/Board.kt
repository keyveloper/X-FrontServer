package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "boards")
@EntityListeners(AuditingEntityListener::class)
class Board (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val writer : Long,

    @Column(name = "text_content")
    var textContent: String,

    @Column(name="file_api_url")
    var fileApiUri: String? = null, // api url

    @CreatedDate
    @Column(name = "first_writing_time")
    var firstWritingDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "last_modified_time")
    var lastModifiedDate: LocalDateTime? = null,

    @Column(name = "reading_count")
    var readingCount : Long = 0,


    @Column(name = "parent_id")
    var parentId: Long? = null,

    var invalid: Boolean = false,
    )