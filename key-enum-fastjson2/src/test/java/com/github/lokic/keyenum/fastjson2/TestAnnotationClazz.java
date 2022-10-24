package com.github.lokic.keyenum.fastjson2;

import com.alibaba.fastjson2.annotation.JSONField;
import com.github.lokic.keyenum.fastjson2.deserialize.KeyEnumDeserializer;
import com.github.lokic.keyenum.fastjson2.serialize.KeyEnumSerializer;
import lombok.Data;

@Data
public class TestAnnotationClazz {

    @JSONField(
            deserializeUsing = KeyEnumDeserializer.class,
            serializeUsing = KeyEnumSerializer.class
    )
    private TestEnum testEnum;

}
