package com.freedom.easydp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 跨域过滤器
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
public class CrosFilter implements Filter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    HttpServletResponse res = (HttpServletResponse) response;
    HttpServletRequest req = (HttpServletRequest) request;

    res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
    res.setHeader("Access-Control-Allow-Credentials", "true");
    res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    res.setHeader("Access-Control-Max-Age", "3600");
    res.setHeader("Access-Control-Allow-Headers",
        "Accept, Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
    res.setCharacterEncoding("utf-8");
    chain.doFilter(request, res);
  }

  @Override
  public void destroy() {
  }

}
