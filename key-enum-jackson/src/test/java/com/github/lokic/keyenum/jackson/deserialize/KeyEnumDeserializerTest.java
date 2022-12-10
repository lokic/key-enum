package com.github.lokic.keyenum.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.lokic.keyenum.jackson.Test2Enum;
import com.github.lokic.keyenum.jackson.TestAnnotationClazz;
import com.github.lokic.keyenum.jackson.TestConfigClazz;
import com.github.lokic.keyenum.jackson.TestEnum;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumDeserializerTest {


    @SneakyThrows
    @Test
    public void deserialize_config() {

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.setDeserializerModifier(new KeyEnumDeserializerModifier());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(simpleModule);

        String json0 = "{\"testEnum\":0,\"test2Enum\":\"a\"}";
        String json1 = "{\"testEnum\":1,\"test2Enum\":\"b\"}";
        String json2 = "{\"testEnum\":2,\"test2Enum\":\"c\"}";
        String json3 = "{\"testEnum\":null,\"test2Enum\":null}";
        String json4 = "{\"testEnum\":3,\"test2Enum\":\"d\"}";

        TestConfigClazz t0 = mapper.readValue(json0, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());
        Assert.assertEquals(Test2Enum.A, t0.getTest2Enum());

        TestConfigClazz t1 = mapper.readValue(json1, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());
        Assert.assertEquals(Test2Enum.B, t1.getTest2Enum());

        TestConfigClazz t2 = mapper.readValue(json2, TestConfigClazz.class);
        Assert.assertNull(t2.getTestEnum());
        Assert.assertNull(t2.getTest2Enum());

        TestConfigClazz t3 = mapper.readValue(json3, TestConfigClazz.class);
        Assert.assertNull(t3.getTestEnum());
        Assert.assertNull(t3.getTest2Enum());

        TestAnnotationClazz t4 = mapper.readValue(json4, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());
        Assert.assertEquals(Test2Enum.D, t4.getTest2Enum());

    }

    @SneakyThrows
    @Test
    public void deserialize_annotation() {
        ObjectMapper mapper = new ObjectMapper();


        String json0 = "{\"testEnum\":0,\"test2Enum\":\"a\"}";
        String json1 = "{\"testEnum\":1,\"test2Enum\":\"b\"}";
        String json2 = "{\"testEnum\":2,\"test2Enum\":\"c\"}";
        String json3 = "{\"testEnum\":null,\"test2Enum\":null}";
        String json4 = "{\"testEnum\":3,\"test2Enum\":\"d\"}";

        TestAnnotationClazz t0 = mapper.readValue(json0, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());
        Assert.assertEquals(Test2Enum.A, t0.getTest2Enum());

        TestAnnotationClazz t1 = mapper.readValue(json1, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());
        Assert.assertEquals(Test2Enum.B, t1.getTest2Enum());

        TestAnnotationClazz t2 = mapper.readValue(json2, TestAnnotationClazz.class);
        Assert.assertNull(t2.getTestEnum());
        Assert.assertNull(t2.getTest2Enum());

        TestAnnotationClazz t3 = mapper.readValue(json3, TestAnnotationClazz.class);
        Assert.assertNull(t3.getTestEnum());
        Assert.assertNull(t3.getTest2Enum());

        TestAnnotationClazz t4 = mapper.readValue(json4, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());
        Assert.assertEquals(Test2Enum.D, t4.getTest2Enum());

    }

}