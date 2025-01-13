package com.example.frontServer.validator;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/example/frontServer/validator/PasswordConstraintValidator;", "Ljakarta/validation/ConstraintValidator;", "Lcom/example/frontServer/annotaion/ValidPassword;", "", "()V", "isValid", "", "password", "context", "Ljakarta/validation/ConstraintValidatorContext;", "frontServer"})
public final class PasswordConstraintValidator implements jakarta.validation.ConstraintValidator<com.example.frontServer.annotaion.ValidPassword, java.lang.String> {
    
    public PasswordConstraintValidator() {
        super();
    }
    
    @java.lang.Override()
    public boolean isValid(@org.jetbrains.annotations.Nullable()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    jakarta.validation.ConstraintValidatorContext context) {
        return false;
    }
}