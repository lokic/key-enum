package com.github.lokic.keyenum.fastjson.deserialize;

import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.github.lokic.keyenum.core.KeyEnumMatcher;

public class EnumDeserializerProvider implements KeyEnumMatcher {
    private final KeyEnumDeserializer keyEnumDeserializer;

    public EnumDeserializerProvider() {
        this.keyEnumDeserializer = new KeyEnumDeserializer();
    }

    public ObjectDeserializer getEnumDeserializer(Class<?> clazz) {
        if (KeyEnumMatcher.isKeyEnum(clazz)) {
            return keyEnumDeserializer;
        } else {
            return new EnumDeserializer(clazz);
        }
    }


}
