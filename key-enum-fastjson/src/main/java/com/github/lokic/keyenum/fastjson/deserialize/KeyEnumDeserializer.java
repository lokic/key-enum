package com.github.lokic.keyenum.fastjson.deserialize;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.github.lokic.keyenum.core.KeyEnum;

import java.lang.reflect.Type;

public class KeyEnumDeserializer implements ObjectDeserializer {


    @SuppressWarnings("unchecked")
    @Override
    public <E> E deserialze(DefaultJSONParser parser, Type type, Object o) {
        final JSONLexer lexer = parser.lexer;

        final int token = lexer.token();
        if (token == JSONToken.NULL) {
            lexer.nextToken(JSONToken.COMMA);
            return null;
        } else {
            if (type instanceof Class) {
                Class<E> keyEnumClass = (Class<E>) type;
                Object value = parser.parse();
                return (E) KeyEnum.keyOf((Class) keyEnumClass, value);
            }
        }
        Object value = parser.parse();
        throw new JSONException("parse key enum " + type.getTypeName() + " error, value : " + value);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
