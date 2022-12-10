package com.github.lokic.keyenum.mapstruct.converter;

import com.github.lokic.keyenum.core.KeyEnum;

public enum TrafficLight2 implements KeyEnum<String, TrafficLight2> {
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
