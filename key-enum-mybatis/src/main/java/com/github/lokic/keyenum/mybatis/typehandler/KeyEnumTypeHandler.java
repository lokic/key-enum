package com.github.lokic.keyenum.mybatis.typehandler;

import com.github.lokic.keyenum.core.KeyEnum;
import lombok.SneakyThrows;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(KeyEnum.class)
@MappedJdbcTypes({JdbcType.INTEGER, JdbcType.VARCHAR})
public class KeyEnumTypeHandler<K, E extends Enum<E> & KeyEnum<K, E>> extends BaseTypeHandler<E> {
    private final Class<E> clazz;

    @SneakyThrows
    public KeyEnumTypeHandler(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i, e.getKey());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        @SuppressWarnings("unchecked")
        K key = (K) resultSet.getObject(s);
        return keyOf(key);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        @SuppressWarnings("unchecked")
        K key = (K) resultSet.getObject(i);
        return keyOf(key);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        @SuppressWarnings("unchecked")
        K key = (K) callableStatement.getObject(i);
        return keyOf(key);
    }

    @SneakyThrows
    private E keyOf(K key) {
        return KeyEnum.keyOf(clazz, key);
    }
}
