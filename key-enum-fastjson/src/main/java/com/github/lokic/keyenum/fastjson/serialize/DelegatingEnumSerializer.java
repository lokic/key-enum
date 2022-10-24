package com.github.lokic.keyenum.fastjson.serialize;

import com.alibaba.fastjson.serializer.EnumSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.github.lokic.keyenum.core.KeyEnumMatcher;

import java.io.IOException;
import java.lang.reflect.Type;

public class DelegatingEnumSerializer implements ObjectSerializer {

    private final KeyEnumSerializer keyEnumSerializer;

    public DelegatingEnumSerializer() {
        this.keyEnumSerializer = new KeyEnumSerializer();
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (KeyEnumMatcher.isKeyEnum(fieldType)) {
            keyEnumSerializer.write(serializer, object, fieldName, fieldType, features);
        } else {
            EnumSerializer.instance.write(serializer, object, fieldName, fieldType, features);
        }
    }
}
