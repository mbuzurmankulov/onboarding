package com.epam.dela.dao;

import com.epam.dela.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers(Integer page, Integer size);

    User create(User user);
}
