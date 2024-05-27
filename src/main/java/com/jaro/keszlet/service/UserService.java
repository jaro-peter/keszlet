package com.jaro.keszlet.service;

import com.jaro.keszlet.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void saveUser(User user);
}