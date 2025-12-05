package com.bird.bluebirdproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.bird.bluebirdproject.mapper")
public class BlueBirdProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueBirdProjectApplication.class, args);
    }

}
