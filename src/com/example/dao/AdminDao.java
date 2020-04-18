package com.example.dao;

import com.example.domain.Admin;

import java.util.List;

public interface AdminDao {
    public Admin login(Admin admin);

    public List<Admin> findAll();

    public int delete(Admin admin);
}
