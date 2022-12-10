package com.github.lokic.keyenum.fastjson.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.github.lokic.keyenum.fastjson.Test2Enum;
import com.github.lokic.keyenum.fastjson.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson.TestConfigClazz;
import com.github.lokic.keyenum.fastjson.TestEnum;
import org.junit.Assert;
import org.junit.Test;

public class KeyEnumSerializerTest {

    @Test
    public void write_annotation() {

        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"b\",\"testEnum\":1}";
        String json2 = "{}";
        String json3 = "{\"test2Enum\":\"d\",\"testEnum\":3}";

        TestAnnotationClazz t0 = new TestAnnotationClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0));

        TestAnnotationClazz t1 = new TestAnnotationClazz();
        t1.setTestEnum(TestEnum.B);
        t1.setTest2Enum(Test2Enum.B);
        Assert.assertEquals(json1, JSON.toJSONString(t1));

        TestAnnotationClazz t2 = new TestAnnotationClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2));

        TestAnnotationClazz t3 = new TestAnnotationClazz();
        t3.setTestEnum(TestEnum.D);
        t3.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json3, JSON.toJSONString(t3));
    }

    @Test
    public void write_general_config() {
        SerializeConfig config = new SerializeConfig() {
            @Override
            protected ObjectSerializer getEnumSerializer() {
                return new DelegatingEnumSerializer();
            }
        };
        write_config(config);
    }

    @Test
    public void write_single_config() {
        SerializeConfig config = new SerializeConfig();
        config.put(TestEnum.class, new KeyEnumSerializer());
        config.put(Test2Enum.class, new KeyEnumSerializer());
        write_config(config);
    }

    private void write_config(SerializeConfig config) {
        String json0 = "{\"test2Enum\":\"a\",\"testEnum\":0}";
        String json1 = "{\"test2Enum\":\"b\",\"testEnum\":1}";
        String json2 = "{}";
        String json3 = "{\"test2Enum\":\"d\",\"testEnum\":3}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        t0.setTest2Enum(Test2Enum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0, config));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.B);
        t1.setTest2Enum(Test2Enum.B);
        Assert.assertEquals(json1, JSON.toJSONString(t1, config));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2, config));

        TestConfigClazz t3 = new TestConfigClazz();
        t3.setTestEnum(TestEnum.D);
        t3.setTest2Enum(Test2Enum.D);
        Assert.assertEquals(json3, JSON.toJSONString(t3, config));
    }

}