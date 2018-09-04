package com.freedom.easydp.filter;

import com.freedom.easydp.auth.AuthValidator;
import com.freedom.easydp.auth.SessionAuthValidator;
import com.freedom.easydp.entity.UserEntity;
import com.freedom.easydp.exception.ServiceException.ErrorCode;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.UserThreadLocal;
import com.freedom.easydp.utils.JsonUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录拦截器
 *
 * @author nan.zhou
 * @Date 2018-03-15
 */
public class AuthFilter implements Filter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void init(FilterConfig filterConfig) {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    AuthValidator validator = new SessionAuthValidator();
    UserEntity user = validator.validate(servletRequest, servletResponse);
    if (user == null) {
      HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
      renderUnAuthorizedResponse(httpServletResponse);
      return;
    }
    UserThreadLocal.setUser(user);
    filterChain.doFilter(servletRequest, servletResponse);
  }

  private void renderUnAuthorizedResponse(HttpServletResponse response) throws IOException {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(ErrorCode.UN_AUTHENTICATED.getValue());
    apiResponse.setErrMsg("Unauthenticated exception");
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(JsonUtil.objToJson(apiResponse));
  }

  @Override
  public void destroy() {
  }

}
