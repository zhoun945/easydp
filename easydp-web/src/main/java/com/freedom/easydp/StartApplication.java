package com.freedom.easydp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 应用启动类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StartApplication {

  public static void main(String[] args) {
    SpringApplication.run(StartApplication.class, args);
  }

}
