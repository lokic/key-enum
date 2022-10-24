package com.github.lokic.keyenum.fastjson.deserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.fastjson.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson.TestConfigClazz;
import com.github.lokic.keyenum.fastjson.TestEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;


public class KeyEnumDeserializerTest {

    @Test
    public void deserialze_annotation() {
        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":3}";


        TestAnnotationClazz t0 = JSON.parseObject(json0, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestAnnotationClazz t1 = JSON.parseObject(json1, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestAnnotationClazz t2 = JSON.parseObject(json2, TestAnnotationClazz.class);
        Assert.assertNull(t2.getTestEnum());

        TestAnnotationClazz t3 = JSON.parseObject(json3, TestAnnotationClazz.class);
        Assert.assertNull(t3.getTestEnum());

        TestAnnotationClazz t4 = JSON.parseObject(json4, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());
    }


    @Test
    public void deserialze_config() {
        EnumDeserializerProvider enumDeserializerProvider = new EnumDeserializerProvider();

        ParserConfig config = new ParserConfig() {
            @Override
            protected ObjectDeserializer getEnumDeserializer(Class<?> clazz) {
                return enumDeserializerProvider.getEnumDeserializer(clazz);
            }
        };

        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":3}";


        TestConfigClazz t0 = JSON.parseObject(json0, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestConfigClazz t1 = JSON.parseObject(json1, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestConfigClazz t2 = JSON.parseObject(json2, TestConfigClazz.class, config);
        Assert.assertNull(t2.getTestEnum());

        TestConfigClazz t3 = JSON.parseObject(json3, TestConfigClazz.class, config);
        Assert.assertNull(t3.getTestEnum());

        TestConfigClazz t4 = JSON.parseObject(json4, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());

    }
}