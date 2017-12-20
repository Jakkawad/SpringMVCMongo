package com.java.dao;

import com.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "user";
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
    }

    public void add(User user) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);

        }
        user.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(user, COLLECTION_NAME);
    }

    public void update(User user) {
        mongoTemplate.save(user);
    }

    public void delete(User user) {
        mongoTemplate.remove(user, COLLECTION_NAME);
    }

    public User findUserById(String id) {
        return mongoTemplate.findById(id, User.class);
    }
}
