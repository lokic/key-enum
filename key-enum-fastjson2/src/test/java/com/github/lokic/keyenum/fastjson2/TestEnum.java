package com.github.lokic.keyenum.fastjson2;

import com.github.lokic.keyenum.core.KeyEnum;

public enum TestEnum implements KeyEnum<Integer, TestEnum> {
    A(0),
    B(1),
    D(3);

    private final int key;

    TestEnum(int key) {
        this.key = key;
    }

    @Override
    public Integer getKey() {
        return key;
    }
}
