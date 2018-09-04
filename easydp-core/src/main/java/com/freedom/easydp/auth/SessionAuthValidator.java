package com.freedom.easydp.auth;

import com.freedom.easydp.entity.UserEntity;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Session用户认证校验器
 *
 * @author nan.zhou
 * @Date 2018-03-15
 */
public class SessionAuthValidator implements AuthValidator {

  @Override
  public UserEntity validate(ServletRequest servletRequest, ServletResponse servletResponse) {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpSession session = request.getSession();
    UserEntity userEntity = (UserEntity) session.getAttribute(USER_METADATA);
    return userEntity;
  }

}
