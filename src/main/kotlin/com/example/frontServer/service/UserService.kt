package com.example.frontServer.service

import com.example.frontServer.dto.user.UserResult
import com.example.frontServer.dto.auth.SignUpRequest
import com.example.frontServer.entity.User
import com.example.frontServer.entity.UserRole
import com.example.frontServer.exception.CanNotFindEntity
import com.example.frontServer.exception.InValidIdException
import com.example.frontServer.repository.UserRepository
import com.example.frontServer.repository.UserRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun signUp(request: SignUpRequest) {
        // unique check: Exception Handler
        //
        val user = User(
            email = request.email,
            username = request.username,
            password = passwordEncoder.encode(request.password),
            introduction = request.introduction,
            birthday = request.birthday,
            country = request.country
        )
        userRepository.save(user)

        userRoleRepository.save(
            UserRole(
                user = user.id!!,
                role = request.role.ordinal.toLong()
            )
        )
    }

    fun findUserByuUsername(username: String): UserResult? {
        val user = userRepository.findByUsername(username)
            ?: throw CanNotFindEntity()

        return UserResult.of(user)
    }

    fun findUsernameById(id: Long): String? {
        val optionalUser: Optional<User> = userRepository.findById(id)
        return if (optionalUser.isPresent) {
            optionalUser.get().username
        } else {
            throw InValidIdException()
        }
    }
}