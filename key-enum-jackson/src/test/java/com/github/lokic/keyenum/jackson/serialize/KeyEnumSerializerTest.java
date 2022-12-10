package com.github.lokic.keyenum.jackson.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.lokic.keyenum.jackson.Test2Enum;
import com.github.lokic.keyenum.jackson.TestAnnotationClazz;
import com.github.lokic.keyenum.jackson.TestConfigClazz;
import com.github.lokic.keyenum.jackson.TestEnum;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumSerializerTest {

    @SneakyThrows
    @Test
    public void serialize_config() {

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setSerializerModifier(new KeyEnumSerializerModifier());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(simpleModule);


        String json0 = "{\"testEnum\":0,\"test2Enum\":\"a\"}";
        String json1 = "{\"testEnum\":1,\"test2Enum\":\"b\"}";
        String json2 = "{\"testEnum\":null,\"test2Enum\":null}";
        String json3 = "{\"testEnum\":3,\"test2Enum\":\"d\"}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        Assert.assertEquals(json0, mapper.writeValueAsString(t0));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.B);
        t1.setTest2Enum(Test2Enum.B);
        Assert.assertEquals(json1, mapper.writeValueAsString(t1));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, mapper.writeValueAsString(t2));

        TestConfigClazz t3 = new TestConfigClazz();
        t3.setTestEnum(TestEnum.D);
        t3.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json3, mapper.writeValueAsString(t3));

    }


    @SneakyThrows
    @Test
    public void serialize_annotation() {
        ObjectMapper mapper = new ObjectMapper();

        String json0 = "{\"testEnum\":0,\"test2Enum\":\"a\"}";
        String json1 = "{\"testEnum\":1,\"test2Enum\":\"b\"}";
        String json2 = "{\"testEnum\":null,\"test2Enum\":null}";
        String json3 = "{\"testEnum\":3,\"test2Enum\":\"d\"}";

        TestAnnotationClazz t0 = new TestAnnotationClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        Assert.assertEquals(json0, mapper.writeValueAsString(t0));

        TestAnnotationClazz t1 = new TestAnnotationClazz();
        t1.setTestEnum(TestEnum.B);
        t1.setTest2Enum(Test2Enum.B);
        Assert.assertEquals(json1, mapper.writeValueAsString(t1));

        TestAnnotationClazz t2 = new TestAnnotationClazz();
        Assert.assertEquals(json2, mapper.writeValueAsString(t2));

        TestAnnotationClazz t3 = new TestAnnotationClazz();
        t3.setTestEnum(TestEnum.D);
        t3.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json3, mapper.writeValueAsString(t3));
    }
}