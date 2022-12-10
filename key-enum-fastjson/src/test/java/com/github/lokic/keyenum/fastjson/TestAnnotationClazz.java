package com.github.lokic.keyenum.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.lokic.keyenum.fastjson.deserialize.KeyEnumDeserializer;
import com.github.lokic.keyenum.fastjson.serialize.KeyEnumSerializer;
import lombok.Data;

@Data
public class TestAnnotationClazz {

    @JSONField(
            deserializeUsing = KeyEnumDeserializer.class,
            serializeUsing = KeyEnumSerializer.class
    )
    private TestEnum testEnum;

    @JSONField(
            deserializeUsing = KeyEnumDeserializer.class,
            serializeUsing = KeyEnumSerializer.class
    )
    private Test2Enum test2Enum;

}
