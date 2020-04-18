package com.example.service.impl;


import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserListService;

import java.util.List;

public class UserListServiceImpl implements UserListService {
    @Override
    public List<User> findAll() {
        return new UserDaoImpl().findAll();
    }

}
