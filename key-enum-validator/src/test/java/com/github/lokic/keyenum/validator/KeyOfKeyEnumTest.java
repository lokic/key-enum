package com.github.lokic.keyenum.validator;

import com.github.lokic.keyenum.validator.constraints.KeyOfKeyEnum;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class KeyOfKeyEnumTest {

    @Test
    public void test() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        TestClass t1 = new TestClass();
        Set<ConstraintViolation<TestClass>> result1 = validator.validate(t1);
        Assert.assertEquals(0, result1.size());

        TestClass t2 = new TestClass();
        t2.setKey(1);
        Set<ConstraintViolation<TestClass>> result2 = validator.validate(t2);
        Assert.assertEquals(0, result2.size());

        TestClass t3 = new TestClass();
        t3.setKey(2);
        Set<ConstraintViolation<TestClass>> result3 = validator.validate(t3);
        Assert.assertEquals(1, result3.size());
        Assert.assertEquals("not a key of KeyEnum", result3.stream().findFirst().get().getMessage());
    }


    @Test
    public void test2() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Test2Class t1 = new Test2Class();
        Set<ConstraintViolation<Test2Class>> result1 = validator.validate(t1);
        Assert.assertEquals(0, result1.size());

        Test2Class t2 = new Test2Class();
        t2.setKey2("a");
        Set<ConstraintViolation<Test2Class>> result2 = validator.validate(t2);
        Assert.assertEquals(0, result2.size());

        Test2Class t3 = new Test2Class();
        t3.setKey2("c");
        Set<ConstraintViolation<Test2Class>> result3 = validator.validate(t3);
        Assert.assertEquals(1, result3.size());
        Assert.assertEquals("not a key of KeyEnum", result3.stream().findFirst().get().getMessage());
    }

    @Data
    public static class TestClass {
        @KeyOfKeyEnum(keyEnumClass = TestEnum.class)
        Integer key;


    }

    @Data
    public static class Test2Class {
        @KeyOfKeyEnum(keyEnumClass = Test2Enum.class)
        String key2;
    }
}
