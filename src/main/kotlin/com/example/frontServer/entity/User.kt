package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    var email: String,

    @Column(unique = true)
    var username: String,

    @Column(name = "user_img")
    var userImg: String?, // need modify !!

    var password: String,

    var introduction: String?,

    var birthday: LocalDate?,

    @CreatedDate
    var firstMadeDate : LocalDateTime?,

    var country: String?,
    )

