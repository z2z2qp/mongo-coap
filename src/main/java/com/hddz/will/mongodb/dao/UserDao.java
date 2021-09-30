package com.hddz.will.mongodb.dao;

import java.util.List;

import com.hddz.will.mongodb.mode.PageMessage;
import com.hddz.will.mongodb.mode.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final MongoTemplate template;

    public UserDao(MongoTemplate template) {
        this.template = template;
    }

    public void save(User user) {
        template.save(user);
    }

    public User findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return template.findOne(query, User.class);
    }

    public void update(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName());
        UpdateResult result = template.updateFirst(query, update, User.class);
        System.out.println(result);
    }

    public void delete(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        template.remove(query, User.class);
    }

    public PageMessage<User> page(int page,int rows,String sort){
        Query query = new Query();
        long count = template.count(query, User.class);
        Pageable pageable = PageRequest.of(page, rows);
        query.with(pageable);
        query.with(Sort.by(Sort.Order.asc(sort)));
        List<User> list = template.find(query, User.class);
        return new PageMessage<>(page, list, rows, count);
    }

}