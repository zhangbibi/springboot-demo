package com.demo;

import com.demo.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {


        ApplicationContext app = SpringApplication.run(SpringbootDemoApplication.class, args);

        SpringContextUtil.setApplicationContext(app);
    }

}
