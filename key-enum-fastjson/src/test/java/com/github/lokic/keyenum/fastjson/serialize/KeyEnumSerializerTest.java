package com.github.lokic.keyenum.fastjson.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.github.lokic.keyenum.core.KeyEnum;
import com.github.lokic.keyenum.fastjson.TestAnnotationClazz;
import com.github.lokic.keyenum.fastjson.TestConfigClazz;
import com.github.lokic.keyenum.fastjson.TestEnum;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

public class KeyEnumSerializerTest {

    @Test
    public void write_annoation() {

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

    @Test
    public void write_config() {
        SerializeConfig config = new SerializeConfig(){
            @Override
            protected ObjectSerializer getEnumSerializer() {
                return new DelegatingEnumSerializer();
            }
        };

        String json0 = "{\"testEnum\":0}";
        String json1 = "{\"testEnum\":1}";
        String json2 = "{}";

        TestConfigClazz t0 = new TestConfigClazz();
        t0.setTestEnum(TestEnum.A);
        Assert.assertEquals(json0, JSON.toJSONString(t0, config));

        TestConfigClazz t1 = new TestConfigClazz();
        t1.setTestEnum(TestEnum.B);
        Assert.assertEquals(json1, JSON.toJSONString(t1, config));

        TestConfigClazz t2 = new TestConfigClazz();
        Assert.assertEquals(json2, JSON.toJSONString(t2, config));
    }
}