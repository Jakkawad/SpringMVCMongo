package com.java.service;

import com.java.model.User;

import java.util.List;

public interface UserService {

    public List<User> listUser();

    public void add(User user);

    public void update(User user);

    public void delete(User user);

    public User findUserById(String id);
}
