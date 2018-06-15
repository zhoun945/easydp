package com.freedom.easydp.exception;

import com.freedom.easydp.exception.ServiceException.ErrorCode;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.ValidError;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ApiResponse errorHandler(Exception e) {
    logger.error("发生异常 errorMsg={}", e.getMessage());
    logger.error("异常信息", e);

    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setErrMsg(e.getMessage());
    if (e instanceof ServiceException) {
      ServiceException ex = (ServiceException) e;
      apiResponse.setCode(ex.getErrorCode());
    } else {
      apiResponse.setCode(ErrorCode.SYS.getValue());
    }
    return apiResponse;
  }

  @ResponseBody
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ApiResponse errorHandler(MethodArgumentNotValidException e) {
    List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
    List<ValidError> validErrorList = new ArrayList<>();
    for (FieldError fieldError : fieldErrorList) {
      ValidError validError = new ValidError();
      validError.setObject(fieldError.getObjectName());
      validError.setField(fieldError.getField());
      validError.setRejectedValue(fieldError.getRejectedValue());
      validError.setMessage(fieldError.getDefaultMessage());
      validErrorList.add(validError);
    }

    logger.error("参数校验未通过", validErrorList);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(ErrorCode.BIZ.getValue());
    apiResponse.setErrMsg("params invalid");
    apiResponse.setData(validErrorList);
    return apiResponse;
  }

}
