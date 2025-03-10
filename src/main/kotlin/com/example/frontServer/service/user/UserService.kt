package com.example.frontServer.service.user

import com.example.frontServer.dto.user.response.UserProfileGetResult
import com.example.frontServer.dto.auth.SignUpRequest
import com.example.frontServer.dto.user.request.UserProfileGetRequest
import com.example.frontServer.entity.User
import com.example.frontServer.entity.UserRole
import com.example.frontServer.enum.EntityType
import com.example.frontServer.exception.NotFoundEntityException
import com.example.frontServer.repository.user.UserRepository
import com.example.frontServer.repository.user.UserRoleRepository
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userFollowService: UserFollowService,
    private val redisUserService: RedisUserService,
) {
    @Transactional
    fun signUp(request: SignUpRequest) {
        // unique check: Exception Handler
        //
        val user = User(
            id = null,
            userImg = null,
            email = request.email,
            username = request.username,
            password = passwordEncoder.encode(request.password),
            introduction = request.introduction,
            birthday = request.birthday,
            country = request.country,
            firstMadeDate = null
        )
        userRepository.save(user)

        userRoleRepository.save(
            UserRole(
                user = user.id!!,
                role = request.role.ordinal.toLong()
            )
        )
    }

    @Transactional
    fun findMainUserProfile(request: UserProfileGetRequest): UserProfileGetResult{
        // first find in redis
        val cachedResult = redisUserService.findByUserId(request.userId)
        cachedResult?.let {
            return it
        }

        // find user
        val user = userRepository.findById(request.userId).orElse(null)

        // find following, follower count
        if (user != null) {
            val newProfileResult = UserProfileGetResult.of(
                user,
                userFollowService.findFollowCount(request.userId)
            )

            // save in redis
            redisUserService.save(newProfileResult)

            return newProfileResult

        } else {
            throw NotFoundEntityException(
                entityType = EntityType.USER.code,
                id = request.userId
            )
        }
    }
}