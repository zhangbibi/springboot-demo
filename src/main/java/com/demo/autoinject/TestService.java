package com.demo.autoinject;

import org.springframework.stereotype.Component;

@Component
public class TestService {
    public String doService(String contxt){
        System.err.printf(contxt+"hello service");
        return  "hello service";
    }
}