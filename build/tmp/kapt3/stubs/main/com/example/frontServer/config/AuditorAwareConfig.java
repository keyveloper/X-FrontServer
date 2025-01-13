package com.example.frontServer.config;

@org.springframework.context.annotation.Configuration()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/frontServer/config/AuditorAwareConfig;", "", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "(Lcom/example/frontServer/repository/user/UserRepository;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "auditorProvider", "Lorg/springframework/data/domain/AuditorAware;", "Lcom/example/frontServer/entity/User;", "frontServer"})
public class AuditorAwareConfig {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public AuditorAwareConfig(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository) {
        super();
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.data.domain.AuditorAware<com.example.frontServer.entity.User> auditorProvider() {
        return null;
    }
}