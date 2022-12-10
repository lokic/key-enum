package com.github.lokic.keyenum.jackson;

import com.github.lokic.keyenum.core.KeyEnum;

public enum Test2Enum implements KeyEnum<String, Test2Enum> {
    A("a"),
    B("b"),
    D("d");

    private final String key;

    Test2Enum(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
