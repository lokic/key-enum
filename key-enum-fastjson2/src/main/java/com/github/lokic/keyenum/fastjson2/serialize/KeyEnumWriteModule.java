package com.github.lokic.keyenum.fastjson2.serialize;

import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.github.lokic.keyenum.core.KeyEnumMatcher;

import java.lang.reflect.Type;

public class KeyEnumWriteModule implements ObjectWriterModule {
    @Override
    public ObjectWriter<?> getObjectWriter(Type objectType, Class objectClass) {
        if (KeyEnumMatcher.isKeyEnum(objectClass)) {
            return new KeyEnumSerializer<>();
        }
        return ObjectWriterModule.super.getObjectWriter(objectType, objectClass);
    }
}
