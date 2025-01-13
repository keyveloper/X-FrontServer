package com.example.frontServer.validator;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/frontServer/validator/BirthdayConstraintValidator;", "Ljakarta/validation/ConstraintValidator;", "Lcom/example/frontServer/annotaion/ValidBirthday;", "Ljava/time/LocalDate;", "()V", "minYear", "", "initialize", "", "constraintAnnotaion", "isValid", "", "birtDay", "context", "Ljakarta/validation/ConstraintValidatorContext;", "frontServer"})
public final class BirthdayConstraintValidator implements jakarta.validation.ConstraintValidator<com.example.frontServer.annotaion.ValidBirthday, java.time.LocalDate> {
    private int minYear = 2012;
    
    public BirthdayConstraintValidator() {
        super();
    }
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.annotaion.ValidBirthday constraintAnnotaion) {
    }
    
    @java.lang.Override()
    public boolean isValid(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate birtDay, @org.jetbrains.annotations.Nullable()
    jakarta.validation.ConstraintValidatorContext context) {
        return false;
    }
}