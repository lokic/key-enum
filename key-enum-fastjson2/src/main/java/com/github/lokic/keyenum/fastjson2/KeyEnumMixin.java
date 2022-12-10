package com.github.lokic.keyenum.fastjson2;

import com.alibaba.fastjson2.annotation.JSONField;

public interface KeyEnumMixin<T> {
    @JSONField(value = true)
    T getKey();
}
