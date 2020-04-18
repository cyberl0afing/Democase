package com.example.utils;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JddbcUtilsTest {
    @Test
    public void test() throws SQLException {
        DataSource dataSource = JdbcUtils.getDataSource();
        System.out.println(dataSource.getConnection());
    }
}
