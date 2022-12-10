package com.github.lokic.keyenum.fastjson2;

import com.github.lokic.keyenum.core.KeyEnum;

public enum Test3Enum implements KeyEnum<Integer, Test3Enum> {
    A(0),
    B(1),
    D(3);

    private final int key;

    Test3Enum(int key) {
        this.key = key;
    }

    @Override
    public Integer getKey() {
        return key;
    }
}
