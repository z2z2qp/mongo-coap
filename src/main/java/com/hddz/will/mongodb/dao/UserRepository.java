package com.hddz.will.mongodb.dao;

import com.hddz.will.mongodb.mode.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer>{
    
    User findByName(String name);

    @DeleteQuery("{'id':?0}")
    void delete(Integer id);

    Page<User> findAll(Pageable pageable);

}