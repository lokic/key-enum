package com.github.lokic.keyenum.validator.constraints;

import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.validator.constraintvalidators.KeyOfKeyEnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = KeyOfKeyEnumValidator.class)
public @interface KeyOfKeyEnum {

    Class<? extends KeyEnum<?>> keyEnumClass();

    String message() default "not a key of KeyEnum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
