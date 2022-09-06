package com.github.lokic.keyenum.core;


import java.util.Map;

public class TypeSafeMap {

    private final Map<?, ?> map;

    public TypeSafeMap(Map<?, ?> map) {
        this.map = map;
    }

    @SuppressWarnings("unchecked")
    public <K, V> Map<K, V> getMap() {
        return (Map<K, V>) map;
    }
}
