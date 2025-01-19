package com.example.frontServer.service.follow

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.dto.follow.FollowSaveRequest
import com.example.frontServer.dto.notification.request.NotificationSaveRequest
import com.example.frontServer.entity.Follow
import com.example.frontServer.enum.NotificationType
import com.example.frontServer.exception.NotFoundEntityException
import com.example.frontServer.repository.follow.FollowRepository
import com.example.frontServer.repository.user.UserRepository
import com.example.frontServer.service.noti.KafkaProducerService
import com.example.frontServer.service.noti.NotificationApiService
import jakarta.transaction.Transactional
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class FollowService(
    private val followRepository: FollowRepository,
    private val userRepository: UserRepository,
    private val kafkaProducerService: KafkaProducerService
) {
    @Transactional
    fun save(request: FollowSaveRequest, followerId: Long) {
        val targetUser = userRepository.findById(request.targetId)
            .orElseThrow {
                NotFoundEntityException(
                    HttpStatus.NOT_FOUND,
                    "can't find follow target id: ${request.targetId}"
                )
            }

        try {
            followRepository.save(
                Follow(
                    id = null,
                    followingId = targetUser.id!!,
                    followerId = followerId,
                    isFollow = true
                )
            )

            // send noti
            kafkaProducerService.sendNoti(
                NotificationSaveRequest(
                    publisherId = targetUser.id!!,
                    receiverId = followerId,
                    notificationType = NotificationType.FOLLOW,
                    targetBoardId = null
                )
            )

        } catch (e: DataIntegrityViolationException) {
            // 원인을 분석하여 ConstraintViolationException 확인
            val cause = e.cause
            if (cause is ConstraintViolationException && cause.sqlState == "23000") {
                // SQLState "23000"은 유니크 제약 조건 위반을 의미
                unFollow(targetUser.id!!, followerId)
            } else {
                throw e // 다른 무결성 위반은 그대로 던지기
            }
        }
    }

    fun findFollowCounts(targetId: Long): FollowCounts{
        return followRepository.findFollowCounts(targetId)
    }

    fun unFollow(followTargetId: Long, followerId: Long) {
        val targetFollowEntityOpt = followRepository.findByFollowingIdAndFollowerId(followTargetId, followerId)
        val targetFollowEntity = targetFollowEntityOpt.get()
        targetFollowEntity.isFollow = false
        followRepository.save(targetFollowEntity)
    }
}