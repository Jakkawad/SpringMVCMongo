package com.java.dao;

import com.java.config.WebConfig;
import com.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

//    ApplicationContext ctx = new AnnotationConfigApplicationContext(WebConfig.class);
//    MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

    private static final String COLLECTION_NAME = "user";

    public List<User> listUser() {
        BasicQuery query1 = (BasicQuery) new BasicQuery("{  }").limit(2);
        Query query2 = new Query();
//        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
//        User userTest = mongoOperations.findOne(query1, User.class);
//        System.out.println(userTest);
//        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
//        return mongoTemplate.findAll(User.class);
        return mongoTemplate.find(query1, User.class);
//        return mongoOperations.findOne(query1, User.class);
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
