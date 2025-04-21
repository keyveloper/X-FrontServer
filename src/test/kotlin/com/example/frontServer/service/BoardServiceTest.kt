package com.example.frontServer.service

import com.example.frontServer.dto.board.BoardWithCommentCount
import com.example.frontServer.dto.board.request.CommentGetRequest
import com.example.frontServer.dto.board.request.SingleBoardRequest
import com.example.frontServer.dto.board.response.CommentResult
import com.example.frontServer.dto.board.response.SingleBoardResult
import com.example.frontServer.entity.Board
import com.example.frontServer.entity.User
import com.example.frontServer.enum.EntityType
import com.example.frontServer.exception.NotFoundEntityException
import com.example.frontServer.repository.board.BoardRepository
import com.example.frontServer.repository.follow.FollowRepository
import com.example.frontServer.repository.user.UserRepository
import com.example.frontServer.service.noti.KafkaProducerService
import com.example.frontServer.service.timeline.TimelineApiService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class BoardServiceTest {

    @Mock
    lateinit var boardRepository: BoardRepository

    @Mock
    lateinit var fileService: FileService

    @Mock
    lateinit var followRepository: FollowRepository

    @Mock
    lateinit var likeApiService: LikeApiService

    @Mock
    lateinit var timelineApiService: TimelineApiService

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var kafkaProducerService: KafkaProducerService

    @InjectMocks
    lateinit var boardService: BoardService

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `findInitComment - Given valid parentId, When calling findInitComment, Then returns list of CommentResult`() {
        // Given
        val parentId = 1L
        val request = CommentGetRequest(parentId = parentId, endCommentId = 0L)

        //  fake data
        val board = Board(
            id = 3L,
            writerId = 1L,
            textContent = "this is a test board",
            fileApiUrl = null,
            createdAt = LocalDateTime.now(),
            lastModifiedAt = LocalDateTime.now(),
            readingCount = 0,
            parentId = null,
            invalid = false
        )
        val dummyBoardWithCommentCount = BoardWithCommentCount(
            board = board,
            commentCount = 0L
        )
        `when`(boardRepository.findInitComment(parentId)).thenReturn(listOf(dummyBoardWithCommentCount))

        val dummyUser = Optional.of(User(
            id = 1L,
            email = "test@example.com",
            username = "testUser",
            userImg = null,
            password = "test",
            introduction = null,
            birthday = null,
            firstMadeDate = LocalDateTime.now(),
            country = null
        ))
        `when`(userRepository.findById(1L)).thenReturn(dummyUser)
        `when`(likeApiService.fetchLikeCounts(3L)).thenReturn(5L)

        // when
        val result: List<CommentResult> = boardService.findInitComment(request)

        // Then
        assertNotNull(result)
        assertEquals(1, result.size)
        assertEquals("testUser", result[0].writerName)
        assertEquals(5L, result[0].likeCount)
        verify(boardRepository).findInitComment(parentId)
    }

    @Test
    fun `findSingleBoard - Given existing board, when calling findSingleBoard, then returns SingleBoardResult`() {
        // Given
        val boardId = 200L
        val request = SingleBoardRequest(boardId = boardId)
        val board = Board(
            id = 200L,
            writerId = 10L,
            textContent = "findSingleBoard method test ! ",
            fileApiUrl = null,
            createdAt = LocalDateTime.now(),
            lastModifiedAt = LocalDateTime.now(),
            readingCount = 0,
            parentId = null,
            invalid = false
        )
        `when`(boardRepository.findById(boardId)).thenReturn(Optional.of(board))
        val dummyUser = Optional.of(
            User(
                id = 10L,
                email = "test@example.com",
                username = "singleUser",
                userImg = null,
                password = "test",
                introduction = null,
                birthday = null,
                firstMadeDate = LocalDateTime.now(),
                country = null
            )
        )
        `when`(userRepository.findById(10L)).thenReturn(dummyUser)
        `when`(likeApiService.fetchLikeCounts(boardId)).thenReturn(1200L)

        // when
        val result: SingleBoardResult = boardService.findSingleBoard(request)

        // Then
        assertNotNull(result)
        assertEquals("singleUser", result.writerName)
        assertEquals(1200L, result.likeCount)
        verify(boardRepository).findById(boardId)
    }

    @Test
    fun `findSingleBoard - Given non-existing board, when calling findSingleBoard, Then throw NotFoundEntityException`() {
        // Given
        val boardId = 99L
        val request = SingleBoardRequest(boardId = 99L)
        `when`(boardRepository.findById(boardId)).thenReturn(Optional.empty())

        // When & Then
        val exception = assertThrows<NotFoundEntityException> {
            boardService.findSingleBoard(request)
        }
        assertEquals(EntityType.BOARD.code, exception.entityType)
        assertEquals(boardId, exception.id)
        assertEquals(HttpStatus.NOT_FOUND, exception.httpStatus)
        assertEquals("This Entity doesn't exist", exception.message)
        verify(boardRepository).findById(boardId)
    }


}