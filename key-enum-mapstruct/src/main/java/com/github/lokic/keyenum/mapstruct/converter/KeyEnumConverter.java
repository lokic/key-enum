package com.github.lokic.keyenum.mapstruct.converter;

import com.github.lokic.keyenum.core.KeyEnum;
import org.mapstruct.TargetType;

public class KeyEnumConverter {

    public static <K, E extends Enum<E> & KeyEnum<K, E>> K convert(E keyEnum) {
        return KeyEnum.getKey(keyEnum);
    }

    public static <K, E extends Enum<E> & KeyEnum<K, E>> E convert(@TargetType Class<E> enumType, K key) {
        return KeyEnum.keyOf(enumType, key);
    }
}
