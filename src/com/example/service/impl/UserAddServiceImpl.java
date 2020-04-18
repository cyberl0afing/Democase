package com.example.service.impl;

import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserAddService;

public class UserAddServiceImpl implements UserAddService {
    @Override
    public int add(User user) {
        if (user.getName() == null || ("".equals(user.getName()))) {
            return 0;
            //数据非法
        } else {
            return new UserDaoImpl().add(user);
        }
    }
}
