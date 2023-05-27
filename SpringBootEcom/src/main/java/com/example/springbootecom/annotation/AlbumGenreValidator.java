package com.example.springbootecom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class AlbumGenreValidator implements ConstraintValidator<AlbumGenreValidation,String> {
    @Override
    public boolean isValid(String albumGenre, ConstraintValidatorContext constraintValidatorContext) {
        List<String> list = Arrays.asList("Jazz","Pop","Rock","Blues");
        return list.contains(albumGenre);
    }
}
