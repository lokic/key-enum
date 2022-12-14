package com.github.lokic.keyenum.fastjson.deserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.github.lokic.keyenum.fastjson.Test2Enum;
import com.github.lokic.keyenum.fastjson.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson.TestConfigClazz;
import com.github.lokic.keyenum.fastjson.TestEnum;
import org.junit.Assert;
import org.junit.Test;


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
    public void deserialze_general_config() {
        EnumDeserializerProvider enumDeserializerProvider = new EnumDeserializerProvider();

        ParserConfig config = new ParserConfig() {
            @Override
            protected ObjectDeserializer getEnumDeserializer(Class<?> clazz) {
                return enumDeserializerProvider.getEnumDeserializer(clazz);
            }
        };
        deserialze_config(config);
    }

    @Test
    public void deserialze_single_config() {
        ParserConfig config = new ParserConfig();
        config.putDeserializer(TestEnum.class, new KeyEnumDeserializer());
        config.putDeserializer(Test2Enum.class, new KeyEnumDeserializer());
        deserialze_config(config);
    }

    private void deserialze_config(ParserConfig config) {
        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"b\",\"testEnum\":1}";
        String json2 = "{\"test2Enum\":\"c\",\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"test2Enum\":\"d\",\"testEnum\":3}";


        TestConfigClazz t0 = JSON.parseObject(json0, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());
        Assert.assertEquals(Test2Enum.A, t0.getTest2Enum());

        TestConfigClazz t1 = JSON.parseObject(json1, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());
        Assert.assertEquals(Test2Enum.B, t1.getTest2Enum());

        TestConfigClazz t2 = JSON.parseObject(json2, TestConfigClazz.class, config);
        Assert.assertNull(t2.getTestEnum());
        Assert.assertNull(t2.getTest2Enum());

        TestConfigClazz t3 = JSON.parseObject(json3, TestConfigClazz.class, config);
        Assert.assertNull(t3.getTestEnum());
        Assert.assertNull(t3.getTest2Enum());

        TestConfigClazz t4 = JSON.parseObject(json4, TestConfigClazz.class, config);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());
        Assert.assertEquals(Test2Enum.D, t4.getTest2Enum());
    }
}