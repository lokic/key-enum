package com.github.lokic.keyenum.validator.constraintvalidators;

import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.validator.constraints.KeyOfKeyEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class KeyOfKeyEnumValidator implements ConstraintValidator<KeyOfKeyEnum, Object> {

    private Class<? extends KeyEnum<?, ?>> keyEnumClass;

    @Override
    public void initialize(KeyOfKeyEnum constraintAnnotation) {
        keyEnumClass = constraintAnnotation.keyEnumClass();
    }

    @Override
    public boolean isValid(Object key, ConstraintValidatorContext constraintValidatorContext) {
        if (key == null) {
            return true;
        } else {
            @SuppressWarnings("unchecked")
            boolean isValid = KeyEnum.keyOf((Class) keyEnumClass, key) != null;
            return isValid;
        }
    }
}
