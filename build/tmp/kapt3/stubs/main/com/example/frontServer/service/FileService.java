package com.example.frontServer.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/frontServer/service/FileService;", "", "boardImgRepository", "Lcom/example/frontServer/repository/board/BoardImgRepository;", "(Lcom/example/frontServer/repository/board/BoardImgRepository;)V", "saveBoardFile", "", "fileRequest", "Lcom/example/frontServer/dto/file/FileRequest;", "token", "", "frontServer"})
public class FileService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.board.BoardImgRepository boardImgRepository = null;
    
    public FileService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.board.BoardImgRepository boardImgRepository) {
        super();
    }
    
    public void saveBoardFile(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.file.FileRequest fileRequest, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
}