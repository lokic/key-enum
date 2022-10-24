package com.github.lokic.keyenum.fastjson2.deserialize;

import com.alibaba.fastjson2.JSON;
import com.github.lokic.keyenum.fastjson2.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson2.TestConfigClazz;
import com.github.lokic.keyenum.fastjson2.TestEnum;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumDeserializerTest {

    @Test
    public void readObject_config() {
        JSON.register(new KeyEnumReaderModule());

        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":null}";
        String json5 = "{\"testEnum\":3}";


        TestConfigClazz t0 = JSON.parseObject(json0, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestConfigClazz t1 = JSON.parseObject(json1, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestConfigClazz t2 = JSON.parseObject(json2, TestConfigClazz.class);
        Assert.assertNull(t2.getTestEnum());

        TestConfigClazz t3 = JSON.parseObject(json3, TestConfigClazz.class);
        Assert.assertNull(t3.getTestEnum());

        TestConfigClazz t4 = JSON.parseObject(json4, TestConfigClazz.class);
        Assert.assertNull(t4.getTestEnum());

        TestConfigClazz t5 = JSON.parseObject(json5, TestConfigClazz.class);
        Assert.assertEquals(TestEnum.D, t5.getTestEnum());
    }

    @Test
    public void readObject_annotation() {
        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{\"testEnum\":2}";
        String json3 = "{}";
        String json4 = "{\"testEnum\":null}";
        String json5 = "{\"testEnum\":3}";


        TestAnnotationClazz t0 = JSON.parseObject(json0, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.A, t0.getTestEnum());

        TestAnnotationClazz t1 = JSON.parseObject(json1, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.B, t1.getTestEnum());

        TestAnnotationClazz t2 = JSON.parseObject(json2, TestAnnotationClazz.class);
        Assert.assertNull(t2.getTestEnum());

        TestAnnotationClazz t3 = JSON.parseObject(json3, TestAnnotationClazz.class);
        Assert.assertNull(t3.getTestEnum());

        TestAnnotationClazz t4 = JSON.parseObject(json4, TestAnnotationClazz.class);
        Assert.assertNull(t4.getTestEnum());

        TestAnnotationClazz t5 = JSON.parseObject(json5, TestAnnotationClazz.class);
        Assert.assertEquals(TestEnum.D, t5.getTestEnum());
    }
}