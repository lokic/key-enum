package com.github.lokic.keyenum.jackson.serialize;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.github.lokic.keyenum.jackson.JacksonKeyEnumMatcher;

public class KeyEnumSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifyEnumSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (JacksonKeyEnumMatcher.isKeyEnum(type)) {
            return new KeyEnumSerializer<>();
        }
        return super.modifyEnumSerializer(config, type, beanDesc, serializer);
    }
}
