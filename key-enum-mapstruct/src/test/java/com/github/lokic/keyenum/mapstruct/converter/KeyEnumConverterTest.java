package com.github.lokic.keyenum.mapstruct.converter;

import org.junit.Assert;
import org.junit.Test;

public class KeyEnumConverterTest {


    @Test
    public void test_toDto() {
        Crossing c = new Crossing();
        c.setLight(TrafficLight.RED);

        Crossing c2 = new Crossing();
        c2.setLight(TrafficLight.YELLOW);

        Crossing c3 = new Crossing();
        c3.setLight(TrafficLight.GREEN);

        Crossing c4 = new Crossing();
        c4.setLight(null);

        Assert.assertEquals(0, (int) CrossingConverter.INSTANCE.convert(c).getLight());
        Assert.assertEquals(1, (int) CrossingConverter.INSTANCE.convert(c2).getLight());
        Assert.assertEquals(2, (int) CrossingConverter.INSTANCE.convert(c3).getLight());
        Assert.assertNull(CrossingConverter.INSTANCE.convert(c4).getLight());
    }

    @Test
    public void test_fromDto() {
        CrossingDTO dto = new CrossingDTO();
        dto.setLight(0);


        CrossingDTO dto2 = new CrossingDTO();
        dto2.setLight(1);

        CrossingDTO dto3 = new CrossingDTO();
        dto3.setLight(2);

        CrossingDTO dto4 = new CrossingDTO();
        dto4.setLight(null);

        Assert.assertEquals(TrafficLight.RED, CrossingConverter.INSTANCE.convert(dto).getLight());
        Assert.assertEquals(TrafficLight.YELLOW, CrossingConverter.INSTANCE.convert(dto2).getLight());
        Assert.assertEquals(TrafficLight.GREEN, CrossingConverter.INSTANCE.convert(dto3).getLight());
        Assert.assertNull(CrossingConverter.INSTANCE.convert(dto4).getLight());
    }

    @Test
    public void test_toDto_2() {
        Crossing2 c = new Crossing2();
        c.setLight(TrafficLight2.RED);

        Crossing2 c2 = new Crossing2();
        c2.setLight(TrafficLight2.YELLOW);

        Crossing2 c3 = new Crossing2();
        c3.setLight(TrafficLight2.GREEN);

        Crossing2 c4 = new Crossing2();
        c4.setLight(null);

        Assert.assertEquals("A", CrossingConverter.INSTANCE.convert(c).getLight());
        Assert.assertEquals("B", CrossingConverter.INSTANCE.convert(c2).getLight());
        Assert.assertEquals("C", CrossingConverter.INSTANCE.convert(c3).getLight());
        Assert.assertNull(CrossingConverter.INSTANCE.convert(c4).getLight());
    }

    @Test
    public void test_fromDto_2() {
        Crossing2DTO dto = new Crossing2DTO();
        dto.setLight("A");


        Crossing2DTO dto2 = new Crossing2DTO();
        dto2.setLight("B");

        Crossing2DTO dto3 = new Crossing2DTO();
        dto3.setLight("C");

        Crossing2DTO dto4 = new Crossing2DTO();
        dto4.setLight(null);

        Assert.assertEquals(TrafficLight2.RED, CrossingConverter.INSTANCE.convert(dto).getLight());
        Assert.assertEquals(TrafficLight2.YELLOW, CrossingConverter.INSTANCE.convert(dto2).getLight());
        Assert.assertEquals(TrafficLight2.GREEN, CrossingConverter.INSTANCE.convert(dto3).getLight());
        Assert.assertNull(CrossingConverter.INSTANCE.convert(dto4).getLight());
    }

}