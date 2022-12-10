package com.github.lokic.keyenum.core;


import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public interface KeyEnum<K, E extends Enum<E> & KeyEnum<K, E>> {

    TypeSafeMap CACHE = new TypeSafeMap(new ConcurrentHashMap<>());

    K getKey();

    static <K, E extends Enum<E> & KeyEnum<K, E>> K getKey(E enumObj) {
        if (enumObj == null) {
            return null;
        } else {
            return enumObj.getKey();
        }
    }

    static <K, E extends Enum<E> & KeyEnum<K, E>> E keyOf(Class<E> enumType, K key) {
        return getProperty(enumType).of(key);
    }

    static <K, E extends Enum<E> & KeyEnum<K, E>> E keyRequireOf(Class<E> enumType, K key) {
        return getProperty(enumType).requireOf(key);
    }

    static <K, E extends Enum<E> & KeyEnum<K, E>> Optional<E> keyOptOf(Class<E> enumType, K key) {
        return getProperty(enumType).optOf(key);
    }

    static <K, E extends Enum<E> & KeyEnum<K, E>> Property<K, E> getProperty(Class<E> enumType) {
        return CACHE.<Class<E>, Property<K, E>>getMap()
                .computeIfAbsent(enumType, eType ->
                        //Note: JDK-8141508 bug，必须写成 ke -> ke.getKey()，不要使用方法引用
                        new Property<>(eType, keyEnum -> keyEnum.getKey())
                );
    }

}
