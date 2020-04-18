package com.example.service.impl;

import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserDeleteService;

import java.util.ArrayList;
import java.util.List;

public class UserDeleteServiceImpl implements UserDeleteService {
    @Override
    public List<String> delete(String[] ids) {
        //返回删除的用户集合，并在前端展示
        List<String> delete_users_id = new ArrayList<>();
        if (ids != null && ids.length > 0) {
            UserDaoImpl userDao = new UserDaoImpl();
            for (String id : ids) {
                System.out.println("删除" + id);
                if (userDao.deleteById(id) > 0) {
                    delete_users_id.add(id);
                }//成功删除
            }
            return delete_users_id;
        } else {
            return null;
        }

    }

}
