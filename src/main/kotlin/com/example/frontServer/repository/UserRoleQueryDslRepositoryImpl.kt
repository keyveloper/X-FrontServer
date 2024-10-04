package com.example.frontServer.repository

import com.example.frontServer.entity.QRole
import com.example.frontServer.entity.QUser
import com.example.frontServer.entity.QUserRole

import com.example.frontServer.entity.Role
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRoleQueryDslRepositoryImpl (
    private val queryFactory: JPAQueryFactory
) : UserRoleQueryDslRepository{
    private val qUserRole = QUserRole.userRole
    private val qUser = QUser.user
    private val qRole = QRole.role

    override fun findRolesByUsername(username: String): List<Role> {
        return queryFactory
            .select(qUserRole.role())
            .from(qUserRole)
            .join(qUserRole.user(), qUser)
            .join(qUserRole.role(), qRole)
            .where(qUser.username.eq(username))
            .fetch()
    }
}