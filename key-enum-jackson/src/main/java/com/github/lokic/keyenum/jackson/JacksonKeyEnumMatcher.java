package com.github.lokic.keyenum.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.core.KeyEnumMatcher;

import java.util.Objects;

public interface JacksonKeyEnumMatcher extends KeyEnumMatcher {

    static boolean isKeyEnum(JavaType type) {
        for (JavaType typeInterface : type.getInterfaces()) {
            if(Objects.equals(KeyEnum.class, typeInterface.getRawClass())) {
                return true;
            }
        }
        return false;
    }

}
