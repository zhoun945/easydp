package com.freedom.easydp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig
 *
 * @author nan.zhou
 * @Date 2018-08-10
 */
@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
  }

}
