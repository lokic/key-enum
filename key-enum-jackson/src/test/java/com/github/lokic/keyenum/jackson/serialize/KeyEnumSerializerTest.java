package com.github.lokic.keyenum.jackson.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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


        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":null}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        Assert.assertEquals(json0, mapper.writeValueAsString(t0));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.B);
        Assert.assertEquals(json1, mapper.writeValueAsString(t1));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, mapper.writeValueAsString(t2));

    }


    @SneakyThrows
    @Test
    public void serialize_annotation() {
        ObjectMapper mapper = new ObjectMapper();


        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":null}";

        TestAnnotationClazz t0 = new TestAnnotationClazz();
        t0.setTestEnum(TestEnum.A);
        Assert.assertEquals(json0, mapper.writeValueAsString(t0));

        TestAnnotationClazz t1 = new TestAnnotationClazz();
        t1.setTestEnum(TestEnum.B);
        Assert.assertEquals(json1, mapper.writeValueAsString(t1));

        TestAnnotationClazz t2 = new TestAnnotationClazz();
        Assert.assertEquals(json2, mapper.writeValueAsString(t2));
    }
}