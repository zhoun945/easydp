package com.freedom.easydp.utils;

import com.freedom.easydp.exception.ServiceException;

/**
 * 异常工具类
 *
 * @author nan.zhou
 * @Date 2018-07-31
 */
public class ExceptionUtil {

  public static void handleException(Throwable e) {
    if (e instanceof ServiceException) {
      ServiceException serviceException = (ServiceException) e;
      throw serviceException;
    } else {
      throw ServiceException.sys(e.getMessage());
    }
  }

}
