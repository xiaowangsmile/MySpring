package com.main.example.tool.json.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by superMan791 on 2017/5/6.
 */
@Data
public class MyTest {
    private String id;
    private String name;
    private Integer age;
    private List<User> user;
    public String test(){
        return "abcde";
    }
    public String test2(){
        return null;
    }
    public MyTest(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public MyTest() {
    }
}
