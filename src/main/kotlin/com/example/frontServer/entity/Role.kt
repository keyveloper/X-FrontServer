package com.example.frontServer.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "roles")
class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String,

    // mappedBy는 UserRole의 필드 이름과 대응
    @OneToMany(mappedBy = "role", cascade = [CascadeType.ALL], orphanRemoval = true)
    var useRole: MutableSet<UserRole> = mutableSetOf(),
) : Serializable