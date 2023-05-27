package com.example.springbootecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AlbumGenreValidator.class)
public @interface AlbumGenreValidation {

    String message() default "Album Genre is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
