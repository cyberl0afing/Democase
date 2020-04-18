package com.example.service.impl;

import com.example.dao.impl.AdminDaoImpl;
import com.example.domain.Admin;
import com.example.domain.User;
import com.example.service.LoginService;

public class LoginServiceImpl implements LoginService {


    @Override
    public Admin login(Admin admin) {
        return new AdminDaoImpl().login(admin);
    }
}
