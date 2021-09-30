package com.hddz.will.mongodb.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * com.hddz.will.mongodb.service.UserService
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/9/22 15:28
 */
@Service
public class UserService {
    @Async
    public void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s : %d\n","a",System.currentTimeMillis());
    }


    @Async
    public Future<String> b(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s : %d\n","b",System.currentTimeMillis());
        return new AsyncResult<>("a");
    }
}
