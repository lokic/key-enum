package com.github.lokic.keyenum.core;

import java.lang.reflect.Type;
import java.util.Objects;

public interface KeyEnumMatcher {

    static boolean isKeyEnum(Type type) {
        if (type instanceof Class) {
            return isKeyEnum((Class<?>) type);
        }
        return false;
    }

    static boolean isKeyEnum(Class<?> type) {
        for (Class<?> typeInterface : type.getInterfaces()) {
            if (Objects.equals(KeyEnum.class, typeInterface)) {
                return true;
            }
        }
        return false;
    }
}
