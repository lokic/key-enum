package com.github.lokic.keyenum.mapstruct.converter;

import com.github.lokic.keyenum.core.KeyEnum;
import org.mapstruct.TargetType;

public class KeyEnumConverter {

    public static <T extends Enum<T> & KeyEnum<T>> Integer convert(T keyEnum) {
        if (keyEnum == null) {
            return null;
        }
        return keyEnum.getKey();
    }

    public static <T extends Enum<T> & KeyEnum<T>> T convert(@TargetType Class<T> enumType, Integer key) {
        return KeyEnum.keyOf(enumType, key);
    }
}
