package com.qfedu.commonadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qfedu.commonadmin.mapper")
public class CommonadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonadminApplication.class, args);
    }
}
