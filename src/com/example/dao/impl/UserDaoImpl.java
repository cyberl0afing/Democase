package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String query = "select *  from day17_user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findById(String id) {
        String query = "select * from day17_user where id=?";
        try {
            return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<User>(User.class), Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public int add(User user) {
        String update = "INSERT INTO test.day17_user (name, age, gender, address, qq, email) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int count = jdbcTemplate.update(update, user.getName(), user.getAge(), user.getGender(), user.getAddress(), user.getQq(), user.getEmail());
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(User user) {
        String update = "update day17_user set name=?,age=?,gender=?,address=?,qq=?,email=? where id=?";
        int count = 0;
        try {
            count = jdbcTemplate.update(update, user.getName(), user.getAge(), user.getGender(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return count;
        }

    }

    @Override
    public int deleteById(String id) {
        String update = "delete from day17_user where id=?";
        try {
            int count = jdbcTemplate.update(update, Integer.parseInt(id));
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }


}
