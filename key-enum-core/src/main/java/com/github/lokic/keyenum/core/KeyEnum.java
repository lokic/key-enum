package com.github.lokic.keyenum.core;


import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public interface KeyEnum<E extends Enum<E> & KeyEnum<E>> {

    TypeSafeMap CACHE = new TypeSafeMap(new ConcurrentHashMap<>());

    int getKey();

    static <T extends Enum<T> & KeyEnum<T>> T keyOf(Class<T> enumType, Integer key) {
        return getProperty(enumType).of(key);
    }

    static <T extends Enum<T> & KeyEnum<T>> T keyRequireOf(Class<T> enumType, Integer key) {
        return getProperty(enumType).requireOf(key);
    }

    static <T extends Enum<T> & KeyEnum<T>> Optional<T> keyOptOf(Class<T> enumType, Integer key) {
        return getProperty(enumType).optOf(key);
    }

    static <T extends Enum<T> & KeyEnum<T>> Property<T, Integer> getProperty(Class<T> enumType) {
        return CACHE.<Class<T>, Property<T, Integer>>getMap()
                .computeIfAbsent(enumType, eType ->
                        //Note: JDK-8141508 bug，必须写成 ke -> ke.getKey()，不要使用方法引用
                        new Property<>(eType, keyEnum -> keyEnum.getKey())
                );
    }

}
