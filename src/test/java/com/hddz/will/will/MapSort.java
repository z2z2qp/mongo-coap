package com.hddz.will.will;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.hddz.will.will.MapSort
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/26 9:46
 */
public class MapSort {

    private static Map<String,String> map;
    private Map<String,String> bMap = new ConcurrentHashMap<>();
    public void b(Map<String,String> map){
        bMap = map;
    }
    @Test
    public void a(){
        Map<String,String> tree = new HashMap<>();
        b(tree);
        System.out.println(bMap.getClass().getName());

    }

    @BeforeAll
    public static void before(){
        map = new HashMap<>();
        map.put("a","d");
        map.put("b","c");
        map.put("c","b");
        map.put("d","a");
    }

    @Test
    public void test1(){
        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        System.out.println("test1");
        System.out.println(list);
        map.forEach((k,v)->System.out.printf("%s,%s,\n",k,v));
        System.out.println("test1");
    }

    @Test
    public void test2(){
        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        System.out.println("test2");
        System.out.println(list);
        map.entrySet().forEach(it->System.out.printf("%s,%s,\n",it.getKey(),it.getValue()));
        System.out.println("test2");
    }
}
