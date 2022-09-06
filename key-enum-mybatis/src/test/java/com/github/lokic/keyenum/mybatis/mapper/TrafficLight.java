package com.github.lokic.keyenum.mybatis.mapper;

import com.github.lokic.keyenum.core.KeyEnum;

public enum TrafficLight implements KeyEnum<TrafficLight> {
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
