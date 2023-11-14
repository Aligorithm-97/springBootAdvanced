package com.example.springadvanced.validation.notStartWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class NotStartWithImpl implements ConstraintValidator<NotStartWith, String> {
    private NotStartWith notStartWith;

    @Override
    public void initialize(final NotStartWith constraintAnnotation) {
        notStartWith = constraintAnnotation;
    }
    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        return Arrays.stream(notStartWith.value())
                .noneMatch(value::contains);
    }
}
