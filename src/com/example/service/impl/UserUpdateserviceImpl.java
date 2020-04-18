package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserUpdateService;

public class UserUpdateserviceImpl implements UserUpdateService {
    @Override
    public int update(User user) {
        UserDao userDao = new UserDaoImpl();
        if (user != null) {
            return userDao.update(user);
        } else {
            return 0;
        }
    }

    @Override
    public User find(String id) {
        UserDao userDao = new UserDaoImpl();
        User user = null;
        if ((user = userDao.findById(id)) != null) {
            return user;
        }
        return null;
    }
}
