package com.blog.blog.service;

import com.blog.blog.model.User;

public interface UserService {
    User getById(Long id);
    void save(User user);
}
