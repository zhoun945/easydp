package com.freedom.easydp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 配置文件服务
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
@Configuration
public class Properties {

  @Autowired
  private Environment env;

  public String getString(String key) {
    return env.getProperty(key);
  }

  public Integer getInteger(String key) {
    String value = env.getProperty(key);
    return Integer.parseInt(value);
  }

  public Long getLong(String key) {
    String value = env.getProperty(key);
    return Long.parseLong(value);
  }

  public Boolean getBoolean(String key) {
    String value = env.getProperty(key);
    return Boolean.parseBoolean(value);
  }

}
