package com.github.lokic.keyenum.fastjson2.serialize;

import com.alibaba.fastjson2.JSON;
import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.fastjson2.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class KeyEnumSerializerTest {

    @Ignore
    @Test
    public void write_general_config() {
        // fastjson2暂不支持，后续可能会支持。见：https://github.com/alibaba/fastjson2/issues/875
        JSON.register(new KeyEnumWriteModule());
        write_config();
    }

    @Test
    public void write_general_config_mixin() {
        JSON.mixIn(KeyEnum.class, KeyEnumMixin.class);
        write_config();
    }

    @Test
    public void write_single_config() {
        JSON.register(TestEnum.class, new KeyEnumSerializer<>());
        JSON.register(Test2Enum.class, new KeyEnumSerializer<>());
        write_config();
    }

    public void write_config() {
        String json0 = "{\"test2Enum\":\"a\",\"test3Enum\":0,\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"d\",\"testEnum\":3}";
        String json2 = "{}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        t0.setTest3Enum(Test3Enum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.D);
        t1.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json1, JSON.toJSONString(t1));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2));
    }

    @Test
    public void write_annotation() {
        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"d\",\"testEnum\":3}";
        String json2 = "{}";

        TestAnnotationClazz t0 = new TestAnnotationClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0));

        TestAnnotationClazz t1 = new TestAnnotationClazz();
        t1.setTestEnum(TestEnum.D);
        t1.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json1, JSON.toJSONString(t1));

        TestAnnotationClazz t2 = new TestAnnotationClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2));
    }
}