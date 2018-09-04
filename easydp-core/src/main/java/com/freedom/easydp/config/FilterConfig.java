package com.freedom.easydp.config;

import com.freedom.easydp.filter.AuthFilter;
import com.freedom.easydp.filter.CrosFilter;
import com.freedom.easydp.filter.RouteFilter;
import com.freedom.easydp.support.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
@Configuration
@AutoConfigureAfter(Properties.class)
public class FilterConfig {

  @Autowired
  private Properties properties;

  @Bean
  public FilterRegistrationBean accessFilterBean() {
    boolean enabled = properties.getBoolean("app.filter.cros.enabled");
    String[] patterns = properties.getString("app.filter.cros.patterns").split(",");

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new CrosFilter());
    registration.addUrlPatterns(patterns);
    registration.setEnabled(enabled);
    registration.setName("accessFilter");
    return registration;
  }

  @Bean
  public FilterRegistrationBean authFilterBean() {
    boolean enabled = properties.getBoolean("app.filter.auth.enabled");
    String[] patterns = properties.getString("app.filter.auth.patterns").split(",");

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new AuthFilter());
    registration.setEnabled(enabled);
    registration.addUrlPatterns(patterns);
    registration.setName("authFilter");
    return registration;
  }

  @Bean
  public FilterRegistrationBean routeFilterBean() {
    boolean enabled = properties.getBoolean("app.filter.router.enabled");
    String[] patterns = properties.getString("app.filter.router.patterns").split(",");

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new RouteFilter());
    registration.setEnabled(enabled);
    registration.addUrlPatterns(patterns);
    registration.setName("routeFilter");
    return registration;
  }

}
