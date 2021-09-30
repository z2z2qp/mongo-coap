package com.hddz.will.mongodb.controller;

import com.hddz.will.mongodb.dao.UserDao;
import com.hddz.will.mongodb.dao.UserRepository;
import com.hddz.will.mongodb.mode.HttpResult;
import com.hddz.will.mongodb.mode.User;

import com.hddz.will.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Value("${a.b}")
    private List<String> a;
    
    private final UserDao dao;

    private final UserRepository repository;

    private final UserService service;

    public UserController(UserDao dao, UserRepository repository, UserService service) {
        this.dao = dao;
        this.repository = repository;
        this.service = service;
    }

    @PostMapping(value = "save")
    public HttpResult<String> save(@RequestBody User user){
        // dao.save(user);
        repository.save(user);
        return new HttpResult<>(200, null, "succes");
    }

    @GetMapping(value = "list")
    public HttpResult<Page<User>> list(int page,int rows){
        // return new HttpResult<PageMessage<User>>(200, dao.page(page, rows, "name"), "succes");
        return new HttpResult<>(200,repository.findAll(PageRequest.of(page, rows)),"success");
    }

    
    @GetMapping(value = "{name}")
    public HttpResult<User> getByname(@PathVariable String name){
        return new HttpResult<>(200, repository.findByName(name), "succes");
    }

    
    @DeleteMapping(value = "{id}")
    public HttpResult<String> delete(@PathVariable int id){
        repository.delete(id);
        return new HttpResult<>(200, null, "succes");
    }

    
    @PutMapping(value = "update")
    public HttpResult<String> update(@RequestBody User user){
        repository.save(user);
        return new HttpResult<>(200, null, "succes");
    }

    @GetMapping(value = "async")
    public HttpResult<String> async(){
        service.a();
        Future<String> b = service.b();
        while (!b.isDone()){
            try {
                System.out.printf("c: %d\n",System.currentTimeMillis());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String str = "";
        try {
            str = b.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new HttpResult<>(200,str,null);
    }
    
}