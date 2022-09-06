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
@MappedJdbcTypes(JdbcType.INTEGER)
public class KeyEnumTypeHandler<E extends Enum<E> & KeyEnum<E>> extends BaseTypeHandler<E> {
    private final Class<E> clazz;

    public KeyEnumTypeHandler(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, e.getKey());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Integer key = resultSet.getObject(s, Integer.class);
        return keyOf(key);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Integer key = resultSet.getObject(i, Integer.class);
        return keyOf(key);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer key = callableStatement.getObject(i, Integer.class);
        return keyOf(key);
    }

    @SneakyThrows
    private E keyOf(Integer key) {
        return KeyEnum.keyOf(clazz, key);
    }
}
