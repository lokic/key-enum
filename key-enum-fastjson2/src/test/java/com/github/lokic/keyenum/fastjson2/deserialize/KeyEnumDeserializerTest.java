package com.github.lokic.keyenum.fastjson2.deserialize;

import com.alibaba.fastjson2.JSON;
import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.fastjson2.*;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumDeserializerTest {

    @Test
    public void readObject_general_config() {
        JSON.register(new KeyEnumReaderModule());
        readObject_config();
    }

    @Test
    public void readObject_general_config_mixin() {
        JSON.mixIn(KeyEnum.class, KeyEnumMixin.class);
        readObject_config();
    }

    @Test
    public void readObject_single_config() {
        JSON.register(TestEnum.class, new KeyEnumDeserializer<>());
        JSON.register(Test2Enum.class, new KeyEnumDeserializer<>());
        readObject_config();
    }

    private void readObject_config() {
        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0,\"test3Enum\":0}";
        String json1 = "{\"test2Enum\":\"b\",\"testEnum\":1}";
        String json2 = "{\"test2Enum\":\"c\",\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"test2Enum\":null,\"testEnum\":null}";
        String json5 = "{\"test2Enum\":\"d\",\"testEnum\":3}";


        TestConfigClazz t0 = JSON.parseObject(json0, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());
        Assert.assertEquals(Test2Enum.A, t0.getTest2Enum());
        Assert.assertEquals(Test3Enum.A, t0.getTest3Enum());

        TestConfigClazz t1 = JSON.parseObject(json1, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());
        Assert.assertEquals(Test2Enum.B, t1.getTest2Enum());

        TestConfigClazz t2 = JSON.parseObject(json2, TestConfigClazz.class);
        Assert.assertNull(t2.getTestEnum());
        Assert.assertNull(t2.getTest2Enum());

        TestConfigClazz t3 = JSON.parseObject(json3, TestConfigClazz.class);
        Assert.assertNull(t3.getTestEnum());
        Assert.assertNull(t3.getTest2Enum());

        TestConfigClazz t4 = JSON.parseObject(json4, TestConfigClazz.class);
        Assert.assertNull(t4.getTestEnum());
        Assert.assertNull(t4.getTest2Enum());

        TestConfigClazz t5 = JSON.parseObject(json5, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.D, t5.getTestEnum());
        Assert.assertEquals(Test2Enum.D, t5.getTest2Enum());
    }

    @Test
    public void readObject_annotation() {
        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"b\",\"testEnum\":1}";
        String json2 = "{\"test2Enum\":\"c\",\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"test2Enum\":null,\"testEnum\":null}";
        String json5 = "{\"test2Enum\":\"d\",\"testEnum\":3}";


        TestAnnotationClazz t0 = JSON.parseObject(json0, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());
        Assert.assertEquals(Test2Enum.A, t0.getTest2Enum());

        TestAnnotationClazz t1 = JSON.parseObject(json1, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());
        Assert.assertEquals(Test2Enum.B, t1.getTest2Enum());

        TestAnnotationClazz t2 = JSON.parseObject(json2, TestAnnotationClazz.class);
        Assert.assertNull(t2.getTestEnum());
        Assert.assertNull(t2.getTest2Enum());

        TestAnnotationClazz t3 = JSON.parseObject(json3, TestAnnotationClazz.class);
        Assert.assertNull(t3.getTestEnum());
        Assert.assertNull(t3.getTest2Enum());

        TestAnnotationClazz t4 = JSON.parseObject(json4, TestAnnotationClazz.class);
        Assert.assertNull(t4.getTestEnum());
        Assert.assertNull(t4.getTest2Enum());

        TestAnnotationClazz t5 = JSON.parseObject(json5, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t5.getTestEnum());
        Assert.assertEquals(Test2Enum.D, t5.getTest2Enum());
    }
}