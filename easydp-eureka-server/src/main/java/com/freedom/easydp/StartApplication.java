package com.freedom.easydp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 应用启动类
 *
 * @author nan.zhou
 * @date 2018-06-14
 */
@SpringBootApplication
@EnableEurekaServer
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}