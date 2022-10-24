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
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
        final JSONLexer lexer = parser.lexer;

        final int token = lexer.token();
        if (token == JSONToken.LITERAL_INT) {
            if (type instanceof Class) {
                Class<T> keyEnumClass = (Class<T>) type;
                int intValue = lexer.intValue();
                return (T) KeyEnum.keyOf((Class) keyEnumClass, intValue);
            }
        } else if (token == JSONToken.NULL) {
            lexer.nextToken(JSONToken.COMMA);
            return null;
        }
        Object value = parser.parse();
        throw new JSONException("parse key enum " + type.getTypeName() + " error, value : " + value);
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_INT;
    }
}
