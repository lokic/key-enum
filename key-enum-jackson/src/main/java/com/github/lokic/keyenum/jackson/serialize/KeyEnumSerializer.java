package com.github.lokic.keyenum.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.lokic.keyenum.core.KeyEnum;

import java.io.IOException;

public class KeyEnumSerializer<K, E extends Enum<E> & KeyEnum<K, E>>  extends JsonSerializer<E> {


    @Override
    public void serialize(E value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeObject(value.getKey());
    }
}
