package com.github.lokic.keyenum.fastjson2.deserialize;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.github.lokic.keyenum.core.KeyEnum;

import java.lang.reflect.Type;

public class KeyEnumDeserializer<K, E extends Enum<E> & KeyEnum<K, E>> implements ObjectReader<E> {

    @Override
    public E readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        Object key = jsonReader.readAny();
        if (fieldType instanceof Class) {
            @SuppressWarnings("unchecked")
            E e = KeyEnum.keyOf((Class<E>) fieldType, (K) key);
            return e;
        }
        throw new JSONException("parse key enum " + fieldType.getTypeName() + " error, value : " + key);
    }
}
