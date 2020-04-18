package com.example.service;

import com.example.domain.User;

public interface UserUpdateService {
    public int update(User user);

    public User find(String id);
}
