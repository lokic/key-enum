package com.github.lokic.keyenum.jackson.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.lokic.keyenum.core.KeyEnum;

import java.io.IOException;

public class KeyEnumDeserializer<K, E extends Enum<E> & KeyEnum<K, E>> extends StdDeserializer<E> implements ContextualDeserializer {

    private static final long serialVersionUID = -1485479498992558235L;

    public KeyEnumDeserializer() {
        super((JavaType) null);
    }

    public KeyEnumDeserializer(JavaType valueType) {
        super(valueType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        K key = jsonParser.readValueAs(new TypeReference<K>(){});
        return KeyEnum.keyOf((Class<E>) handledType(), key);
    }


    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty property) throws JsonMappingException {
        JavaType type = deserializationContext.getContextualType() != null
                ? deserializationContext.getContextualType()
                : property.getMember().getType();
        return new KeyEnumDeserializer<>(type);
    }
}
