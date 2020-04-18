package com.example.dao.impl;

import com.example.dao.AdminDao;
import com.example.domain.Admin;
import com.example.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Admin login(Admin admin) {
        String query = "select * from day14_user where username=? and password=?";
        try {
            Admin admin_rs = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Admin>(Admin.class), admin.getUsername(), admin.getPassword());
            return admin_rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public int delete(Admin admin) {
        return 0;
    }
}
