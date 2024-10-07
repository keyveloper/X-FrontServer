package com.example.frontServer.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
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
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User,

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    var role: Role,

    @Column(name = "created_at")
    @CreatedDate
    var createdAt: LocalDateTime? = null,

)