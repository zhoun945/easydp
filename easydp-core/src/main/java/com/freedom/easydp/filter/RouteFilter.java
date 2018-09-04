package com.freedom.easydp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 前台路由拦截器（跳转到/index.html 这样才能前端路由）
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
public class RouteFilter implements Filter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void destroy() {
  }

  @Override
  public void init(FilterConfig filterConfig) {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.getRequestDispatcher("/index.html").forward(request, response);
  }

}
