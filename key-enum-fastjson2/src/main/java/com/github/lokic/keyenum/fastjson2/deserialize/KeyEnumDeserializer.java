package com.github.lokic.keyenum.fastjson2.deserialize;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.github.lokic.keyenum.core.KeyEnum;

import java.lang.reflect.Type;

public class KeyEnumDeserializer<E extends Enum<E> & KeyEnum<E>> implements ObjectReader<E> {

    @Override
    public E readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        int key = jsonReader.readInt32Value();
        if (fieldType instanceof Class) {
            @SuppressWarnings("unchecked")
            Class<E> keyEnumClass = (Class<E>) fieldType;
            return KeyEnum.keyOf(keyEnumClass, key);
        }
        throw new JSONException("parse key enum " + fieldType.getTypeName() + " error, value : " + key);
    }
}
