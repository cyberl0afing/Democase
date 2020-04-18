package com.example.dao.test;

import com.example.dao.impl.UserDaoImpl;
import org.junit.Test;

public class AdminDaoImplTest {
    @Test
    public void test() {
        String id = "15";
        System.out.println(Integer.parseInt(id));
        System.out.println(15);
    }

    @Test
    public void test2() {
        new UserDaoImpl().deleteById("12");
    }

    @Test
    public void test3() {

    }
}
