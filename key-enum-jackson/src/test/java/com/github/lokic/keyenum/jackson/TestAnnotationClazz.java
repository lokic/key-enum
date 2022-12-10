package com.github.lokic.keyenum.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.lokic.keyenum.jackson.deserialize.KeyEnumDeserializer;
import com.github.lokic.keyenum.jackson.serialize.KeyEnumSerializer;
import lombok.Data;

@Data
public class TestAnnotationClazz {

    @JsonDeserialize(using = KeyEnumDeserializer.class)
    @JsonSerialize(using = KeyEnumSerializer.class)
    private TestEnum testEnum;

    @JsonDeserialize(using = KeyEnumDeserializer.class)
    @JsonSerialize(using = KeyEnumSerializer.class)
    private Test2Enum test2Enum;
}
