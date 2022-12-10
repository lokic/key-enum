package com.github.lokic.keyenum.core;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class KeyEnumTest {


    @Test
    public void test_keyOf() {
        Assert.assertEquals(TrafficLight.RED, KeyEnum.keyOf(TrafficLight.class, 0));
        Assert.assertEquals(TrafficLight.YELLOW, KeyEnum.keyOf(TrafficLight.class, 1));
        Assert.assertEquals(TrafficLight.GREEN, KeyEnum.keyOf(TrafficLight.class, 2));
        Assert.assertNull(KeyEnum.keyOf(TrafficLight.class, 3));

        Assert.assertEquals(TrafficLight2.RED, KeyEnum.keyOf(TrafficLight2.class, "A"));
        Assert.assertEquals(TrafficLight2.YELLOW, KeyEnum.keyOf(TrafficLight2.class, "B"));
        Assert.assertEquals(TrafficLight2.GREEN, KeyEnum.keyOf(TrafficLight2.class, "C"));
        Assert.assertNull(KeyEnum.keyOf(TrafficLight2.class, "D"));
    }

    @Test
    public void test_optOf() {
        Assert.assertEquals(Optional.of(TrafficLight.RED), KeyEnum.keyOptOf(TrafficLight.class, 0));
        Assert.assertEquals(Optional.of(TrafficLight.YELLOW), KeyEnum.keyOptOf(TrafficLight.class, 1));
        Assert.assertEquals(Optional.of(TrafficLight.GREEN), KeyEnum.keyOptOf(TrafficLight.class, 2));
        Assert.assertEquals(Optional.empty(), KeyEnum.keyOptOf(TrafficLight.class, 3));

        Assert.assertEquals(Optional.of(TrafficLight2.RED), KeyEnum.keyOptOf(TrafficLight2.class, "A"));
        Assert.assertEquals(Optional.of(TrafficLight2.YELLOW), KeyEnum.keyOptOf(TrafficLight2.class, "B"));
        Assert.assertEquals(Optional.of(TrafficLight2.GREEN), KeyEnum.keyOptOf(TrafficLight2.class, "C"));
        Assert.assertEquals(Optional.empty(), KeyEnum.keyOptOf(TrafficLight2.class, "D"));
    }

    @Test
    public void test_requireOf() {
        Assert.assertEquals(TrafficLight.RED, KeyEnum.keyRequireOf(TrafficLight.class, 0));
        Assert.assertEquals(TrafficLight.YELLOW, KeyEnum.keyRequireOf(TrafficLight.class, 1));
        Assert.assertEquals(TrafficLight.GREEN, KeyEnum.keyRequireOf(TrafficLight.class, 2));

        Assert.assertEquals(TrafficLight2.RED, KeyEnum.keyRequireOf(TrafficLight2.class, "A"));
        Assert.assertEquals(TrafficLight2.YELLOW, KeyEnum.keyRequireOf(TrafficLight2.class, "B"));
        Assert.assertEquals(TrafficLight2.GREEN, KeyEnum.keyRequireOf(TrafficLight2.class, "C"));
    }

    @Test(expected = IllegalStateException.class)
    public void test_notFound_requireOf() {
        KeyEnum.keyRequireOf(TrafficLight.class, 3);
    }

    @Test(expected = IllegalStateException.class)
    public void test_notFound_requireOf2() {
        KeyEnum.keyRequireOf(TrafficLight2.class, "D");
    }

    enum TrafficLight implements KeyEnum<Integer, TrafficLight> {
        RED(0),
        YELLOW(1),
        GREEN(2);

        private final int key;

        TrafficLight(int key) {
            this.key = key;
        }

        @Override
        public Integer getKey() {
            return key;
        }
    }

    enum TrafficLight2 implements KeyEnum<String, TrafficLight2> {
        RED("A"),
        YELLOW("B"),
        GREEN("C");

        private final String key;

        TrafficLight2(String key) {
            this.key = key;
        }

        @Override
        public String getKey() {
            return key;
        }
    }

}