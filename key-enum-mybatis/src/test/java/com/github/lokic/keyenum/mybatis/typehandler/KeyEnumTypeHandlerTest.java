package com.github.lokic.keyenum.mybatis.typehandler;

import com.github.lokic.keyenum.mybatis.mapper.TrafficLight;
import com.github.lokic.keyenum.mybatis.mapper.Crossing;
import com.github.lokic.keyenum.mybatis.mapper.CrossingMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class KeyEnumTypeHandlerTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        // create an SqlSessionFactory
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }

        // populate in-memory database
        runScript(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(),
                "CreateDB.sql");
    }

    private static void runScript(DataSource ds, String resource) throws IOException, SQLException {
        try (Connection connection = ds.getConnection()) {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setAutoCommit(true);
            runner.setStopOnError(false);
            runner.setLogWriter(null);
            runner.setErrorLogWriter(null);
            runScript(runner, resource);
        }
    }


    private static void runScript(ScriptRunner runner, String resource) throws IOException, SQLException {
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            runner.runScript(reader);
        }
    }

    @Test
    public void test_selectCrossing() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CrossingMapper mapper = sqlSession.getMapper(CrossingMapper.class);
            Crossing c = mapper.selectById(1L);
            Assert.assertEquals(TrafficLight.YELLOW, c.getLight());

            Crossing c2 = mapper.selectById(2L);
            Assert.assertNull(c2.getLight());
        }
    }

    @Test
    public void test_insertCrossing() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CrossingMapper mapper = sqlSession.getMapper(CrossingMapper.class);
            Crossing c = new Crossing();
            c.setId(100L);
            c.setLight(TrafficLight.GREEN);
            mapper.insert(c);

            Crossing c2 = mapper.selectById(100L);
            Assert.assertEquals(100L, (long) c2.getId());
            Assert.assertEquals(TrafficLight.GREEN, c2.getLight());
        }
    }


    @Test
    public void test_insertNullCrossing() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            CrossingMapper mapper = sqlSession.getMapper(CrossingMapper.class);
            Crossing c = new Crossing();
            c.setId(100L);
            c.setLight(null);
            mapper.insert(c);

            Crossing c2 = mapper.selectById(100L);
            Assert.assertEquals(100L, (long) c2.getId());
            Assert.assertNull(c2.getLight());
        }
    }

}