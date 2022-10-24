package com.github.lokic.keyenum.fastjson.serialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.github.lokic.keyenum.core.KeyEnum;

import java.io.IOException;
import java.lang.reflect.Type;

public class KeyEnumSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if(object == null) {
            serializer.write(null);
        } else if (object instanceof KeyEnum) {
            serializer.write(((KeyEnum<?>) object).getKey());
        }
    }
}
