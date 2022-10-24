package com.github.lokic.keyenum.jackson.deserialize;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.github.lokic.keyenum.jackson.JacksonKeyEnumMatcher;

public class KeyEnumDeserializerModifier extends BeanDeserializerModifier {
    @Override
    public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig config, JavaType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        if (JacksonKeyEnumMatcher.isKeyEnum(type)) {
            return new KeyEnumDeserializer<>();
        }
        return super.modifyEnumDeserializer(config, type, beanDesc, deserializer);
    }
}
