package com.github.lokic.keyenum.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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


        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":3}";

        TestConfigClazz t0 = mapper.readValue(json0, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestConfigClazz t1 = mapper.readValue(json1, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestConfigClazz t2 = mapper.readValue(json2, TestConfigClazz.class);
        Assert.assertNull(t2.getTestEnum());

        TestConfigClazz t3 = mapper.readValue(json3, TestConfigClazz.class);
        Assert.assertNull(t3.getTestEnum());

        TestAnnotationClazz t4 = mapper.readValue(json4, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());

    }

    @SneakyThrows
    @Test
    public void deserialize_annotation() {
        ObjectMapper mapper = new ObjectMapper();


        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":3}";

        TestAnnotationClazz t0 = mapper.readValue(json0, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestAnnotationClazz t1 = mapper.readValue(json1, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestAnnotationClazz t2 = mapper.readValue(json2, TestAnnotationClazz.class);
        Assert.assertNull(t2.getTestEnum());

        TestAnnotationClazz t3 = mapper.readValue(json3, TestAnnotationClazz.class);
        Assert.assertNull(t3.getTestEnum());

        TestAnnotationClazz t4 = mapper.readValue(json4, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t4.getTestEnum());

    }

}