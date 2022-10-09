package com.github.lokic.keyenum.jackson;

import com.github.lokic.keyenum.core.KeyEnum;

public enum TestEnum implements KeyEnum<TestEnum> {
    A(0),
    B(1);

    private final int key;

    TestEnum(int key) {
        this.key = key;
    }

    @Override
    public int getKey() {
        return key;
    }
}