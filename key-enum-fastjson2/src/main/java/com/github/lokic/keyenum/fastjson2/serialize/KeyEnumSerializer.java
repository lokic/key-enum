package com.github.lokic.keyenum.fastjson2.serialize;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.github.lokic.keyenum.core.KeyEnum;

import java.lang.reflect.Type;

public class KeyEnumSerializer<K, E extends Enum<E> & KeyEnum<K, E>> implements ObjectWriter<E> {
    @Override
    public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
        @SuppressWarnings("unchecked")
        K key = KeyEnum.getKey((E) object);
        if (key == null) {
            jsonWriter.writeNull();
        } else {
            jsonWriter.writeAny(key);
        }
    }
}
