package com.github.lokic.keyenum.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.github.lokic.keyenum.core.KeyEnum;

import java.util.Objects;

public interface KeyEnumMatcher {

    default boolean isKeyEnum(JavaType type) {
        for (JavaType typeInterface : type.getInterfaces()) {
            if(Objects.equals(KeyEnum.class, typeInterface.getRawClass())) {
                return true;
            }
        }
        return false;
    }

    default boolean isKeyEnum(Class<?> type) {
        for (Class<?> typeInterface : type.getInterfaces()) {
            if(Objects.equals(KeyEnum.class, typeInterface)) {
                return true;
            }
        }
        return false;
    }
}
