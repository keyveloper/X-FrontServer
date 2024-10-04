package com.example.frontServer.service

import com.example.frontServer.dto.GetUserResult
import com.example.frontServer.dto.SignUpRequest
import com.example.frontServer.entity.User
import com.example.frontServer.entity.UserRole
import com.example.frontServer.enum.RoleNumber
import com.example.frontServer.repository.RoleRepository
import com.example.frontServer.repository.UserRepository
import com.example.frontServer.repository.UserRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun signUp(request: SignUpRequest): String {
        if (userRepository.existsUserByUsername(request.username) ||
            userRepository.existsUserByEmail(request.email)) {
            return "exist username or email"
        }
            
        val user = User(
            email = request.email,
            username = request.username,
            password = passwordEncoder.encode(request.password),
            introduction = request.introduction,
            birthday = request.birthday,
            country = request.country
        )
        // 이 시점에 JPA가 ID와 Auditing기능으로 속성값을 추가할까?

        val normalRole = roleRepository.findByName(RoleNumber.NORMAL.name)
        val userRole = UserRole(
            user = user,
            role = normalRole
        )

        user.userRole.add(userRole)
        userRepository.save(user)

        return "new account enrollment"
    }

    fun findUserByLoginId(loginId: String): GetUserResult? {
        val user = userRepository.findByUsername(loginId)
        return user?.let{ GetUserResult.of(user) }
    }//
}