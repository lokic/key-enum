package com.github.lokic.keyenum.fastjson2.deserialize;

import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.github.lokic.keyenum.core.KeyEnumMatcher;

import java.lang.reflect.Type;

public class KeyEnumReaderModule implements ObjectReaderModule {
    @Override
    public ObjectReader<?> getObjectReader(ObjectReaderProvider provider, Type type) {
        if(KeyEnumMatcher.isKeyEnum((Class<?>) type)) {
            return new KeyEnumDeserializer<>();
        }
        return ObjectReaderModule.super.getObjectReader(provider, type);
    }
}
