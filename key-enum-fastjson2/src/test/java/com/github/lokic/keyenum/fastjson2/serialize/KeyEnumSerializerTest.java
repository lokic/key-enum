package com.github.lokic.keyenum.fastjson2.serialize;

import com.alibaba.fastjson2.JSON;
import com.github.lokic.keyenum.fastjson2.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson2.TestConfigClazz;
import com.github.lokic.keyenum.fastjson2.TestEnum;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumSerializerTest {

    @Test
    public void write_general_config() {
        JSON.register(new KeyEnumWriteModule());
        write_config();
    }

    @Test
    public void write_single_config() {
        JSON.register(TestEnum.class, new KeyEnumSerializer<>());
        write_config();
    }

    public void write_config() {
        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.B);
        Assert.assertEquals(json1, JSON.toJSONString(t1));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2));
    }

    @Test
    public void write_annotation() {
        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{}";

        TestAnnotationClazz t0 = new TestAnnotationClazz();
        t0.setTestEnum(TestEnum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0));

        TestAnnotationClazz t1 = new TestAnnotationClazz();
        t1.setTestEnum(TestEnum.B);
        Assert.assertEquals(json1, JSON.toJSONString(t1));

        TestAnnotationClazz t2 = new TestAnnotationClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2));
    }
}