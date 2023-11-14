package com.example.springadvanced.validation.notStartWith;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,
        ElementType.METHOD,
})
@Documented
@Constraint(validatedBy = {NotStartWithImpl.class})
public @interface NotStartWith {
    String[] value();

    String message() default "hata";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
