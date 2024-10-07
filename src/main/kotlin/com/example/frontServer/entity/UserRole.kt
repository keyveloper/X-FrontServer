package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(
    name = "user_roles",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["user_id", "role_id"])
    ]
)
@EntityListeners(AuditingEntityListener::class)
class UserRole(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var user: Long,

    var role: Int,

    @Column(name = "created_at")
    @CreatedDate
    var createdAt: LocalDateTime? = null,

)