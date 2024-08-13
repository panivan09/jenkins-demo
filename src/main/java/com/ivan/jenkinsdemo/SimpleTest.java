package com.ivan.jenkinsdemo;


import org.springframework.stereotype.Service;

@Service
public class SimpleTest {

    private final String value = "12";

    public String getValue(){
        return value;
    }
}
