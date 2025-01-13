package com.example.frontServer.controller;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0001\u0010\n\u001a\u00020\u000eH\u0017J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0001\u0010\n\u001a\u00020\u000eH\u0017J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\b\u0001\u0010\n\u001a\u00020\u0012H\u0017J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0017J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\u0006\u0010\n\u001a\u00020\u001cH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/frontServer/controller/BoardController;", "", "boardService", "Lcom/example/frontServer/service/board/BoardService;", "(Lcom/example/frontServer/service/board/BoardService;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "deleteById", "Lorg/springframework/http/ResponseEntity;", "Ljava/lang/Void;", "request", "Lcom/example/frontServer/dto/board/request/BoardDeleteRequest;", "findInItComment", "Lcom/example/frontServer/dto/board/response/CommentResponse;", "Lcom/example/frontServer/dto/board/request/CommentGetRequest;", "findNextComment", "findSingleBoard", "Lcom/example/frontServer/dto/board/response/SingleBoardResponse;", "Lcom/example/frontServer/dto/board/request/SingleBoardRequest;", "save", "saveBoardRequest", "Lcom/example/frontServer/dto/board/request/BoardSaveRequest;", "user", "Lcom/example/frontServer/security/AuthUserDetails;", "language", "", "updateContentById", "Lcom/example/frontServer/entity/Board;", "Lcom/example/frontServer/dto/board/request/BoardUpdateRequest;", "frontServer"})
public class BoardController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.board.BoardService boardService = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public BoardController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.board.BoardService boardService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/saveBoard"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> save(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.BoardSaveRequest saveBoardRequest, @org.springframework.security.core.annotation.AuthenticationPrincipal()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.AuthUserDetails user, @org.springframework.web.bind.annotation.RequestHeader(value = "Accept-Language", defaultValue = "en")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/board"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> deleteById(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.BoardDeleteRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/updateBoard"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.entity.Board> updateContentById(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.BoardUpdateRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getComment/init"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.board.response.CommentResponse> findInItComment(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.CommentGetRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getComment/Next"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.board.response.CommentResponse> findNextComment(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.CommentGetRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getSingleBoard"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.board.response.SingleBoardResponse> findSingleBoard(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.SingleBoardRequest request) {
        return null;
    }
}