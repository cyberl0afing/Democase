package com.example.service.test;

import com.example.domain.User;
import com.example.service.impl.UserUpdateserviceImpl;
import org.junit.Test;

public class UserUpdateTest {
    @Test
    public void test() {
        System.out.println(new UserUpdateserviceImpl().find("23"));
    }

    @Test
    public void test2() {
        System.out.println(new UserUpdateserviceImpl().find("24"));
    }

    @Test
    public void test3() {
        User user = new User();
        user.setId(23);
        user.setGender("女");
        user.setName("李四");
        System.out.println(new UserUpdateserviceImpl().update(user));
    }
}
