package com.freedom.easydp.auth;

import com.freedom.easydp.entity.UserEntity;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 用户认证校验器
 *
 * @author nan.zhou
 * @Date 2018-06-15
 */
public interface AuthValidator {

  /**
   * 用户信息
   */
  public final static String USER_METADATA = "USER_METADATA";

  /**
   * 校验方法
   * @param servletRequest
   * @param servletResponse
   *
   * @return !null：校验通过，null：校验失败
   */
  UserEntity validate(ServletRequest servletRequest, ServletResponse servletResponse);

}
