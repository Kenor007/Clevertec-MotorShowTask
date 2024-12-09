package ru.clevertec.motor_show.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.clevertec.motor_show.annotation.impl.ValidatorEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorEnum.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidator {
    Class<? extends Enum<?>> enumClass();

    String message() default "Value must match one of the predefined categories";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
