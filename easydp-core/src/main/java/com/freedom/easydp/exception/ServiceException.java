package com.freedom.easydp.exception;

import java.util.Locale;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 异常定义
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
public class ServiceException extends RuntimeException {

  /**
   * 错误代码
   */
  private Integer errorCode;

  /**
   * 错误信息
   */
  private String errorMsg;

  public ServiceException(ErrorCode errorCode, String errorMsg) {
    super(errorMsg);
    this.errorCode = errorCode.getValue();
    this.errorMsg = errorMsg;
  }

  public ServiceException(ErrorCode errorCode, String errorMsg, Throwable throwable) {
    super(errorMsg, throwable);
    this.errorCode = errorCode.getValue();
    this.errorMsg = errorMsg;
  }

  public static ServiceException sys(String errorMsg) {
    return new ServiceException(ErrorCode.SYS, errorMsg);
  }

  public static ServiceException biz(String errorMsg) {
    return new ServiceException(ErrorCode.BIZ, errorMsg);
  }

  public static ServiceException unAuthenticated(String errorMsg) {
    return new ServiceException(ErrorCode.UN_AUTHENTICATED, errorMsg);
  }

  public static ServiceException unAuthorized(String errorMsg) {
    return new ServiceException(ErrorCode.UN_AUTHORIZED, errorMsg);
  }

  public static ServiceException sys(MessageSource messageSource, String errorCode) {
    Locale locale = LocaleContextHolder.getLocale();
    String message =  messageSource.getMessage(errorCode, null, locale);
    return sys(message);
  }

  public static ServiceException biz(MessageSource messageSource, String errorCode) {
    String message =  messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
    return biz(message);
  }

  public static ServiceException unAuthenticated(MessageSource messageSource) {
    String errorCode = "error.unauthenticated";
    String message =  messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
    return unAuthenticated(message);
  }

  public static ServiceException unAuthorized(MessageSource messageSource) {
    String errorCode = "error.unauthorized";
    String message =  messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
    return unAuthorized(message);
  }

  @Getter
  public enum ErrorCode {

    /**
     * 系统异常: 当系统内部发生不期望的异常时返回
     */
    SYS(-1),

    /**
     * 业务异常: 当请求的参数不满足规则或校验不通过时返回
     */
    BIZ(-2),

    /**
     * 认证异常: 当认证超时或失败时返回
     */
    UN_AUTHENTICATED(-3),

    /**
     * 授权异常: 权限认证失败时返回
     */
    UN_AUTHORIZED(-4);

    private Integer value;

    ErrorCode(Integer value) {
      this.value = value;
    }
  }

}
