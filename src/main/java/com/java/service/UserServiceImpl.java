package com.java.service;

import com.java.dao.UserDao;
import com.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // Bean
    @Autowired
    UserDao userDao;

    public List<User> listUser() {
        return userDao.listUser();
    }

    public void add(User user) {
        userDao.add(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }
}
