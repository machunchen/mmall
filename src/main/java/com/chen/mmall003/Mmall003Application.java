package com.chen.mmall003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chen.mmall003.mapper")
public class Mmall003Application {

    public static void main(String[] args) {
        SpringApplication.run(Mmall003Application.class, args);
    }

}
