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
    }

    @Test
    public void test_optOf() {
        Assert.assertEquals(Optional.of(TrafficLight.RED), KeyEnum.keyOptOf(TrafficLight.class, 0));
        Assert.assertEquals(Optional.of(TrafficLight.YELLOW), KeyEnum.keyOptOf(TrafficLight.class, 1));
        Assert.assertEquals(Optional.of(TrafficLight.GREEN), KeyEnum.keyOptOf(TrafficLight.class, 2));
        Assert.assertEquals(Optional.empty(), KeyEnum.keyOptOf(TrafficLight.class, 3));
    }

    @Test
    public void test_requireOf() {
        Assert.assertEquals(TrafficLight.RED, KeyEnum.keyRequireOf(TrafficLight.class, 0));
        Assert.assertEquals(TrafficLight.YELLOW, KeyEnum.keyRequireOf(TrafficLight.class, 1));
        Assert.assertEquals(TrafficLight.GREEN, KeyEnum.keyRequireOf(TrafficLight.class, 2));
    }

    @Test(expected = IllegalStateException.class)
    public void test_notFound_requireOf() {
        KeyEnum.keyRequireOf(TrafficLight.class, 3);
    }


    enum TrafficLight implements KeyEnum<TrafficLight> {
        RED(0),
        YELLOW(1),
        GREEN(2);

        private final int key;

        TrafficLight(int key) {
            this.key = key;
        }

        @Override
        public int getKey() {
            return key;
        }
    }

}