package com.example.frontServer.repository.user

import com.example.frontServer.entity.UserRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRoleRepository: JpaRepository<UserRole, Long>, UserRoleQueryDslRepository {
}