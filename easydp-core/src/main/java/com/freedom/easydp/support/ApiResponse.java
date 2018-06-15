package com.freedom.easydp.support;

import java.io.Serializable;
import lombok.Data;

/**
 * 接口响应结果
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
public class ApiResponse<T> implements Serializable {

  private Integer code;
  private String errMsg;
  private T data;

  public ApiResponse() {
    super();
  }

  public ApiResponse(Integer code, T data) {
    this.code = code;
    this.data = data;
  }

  public ApiResponse success() {
    return success(Boolean.TRUE);
  }

  public ApiResponse success(Object data) {
    return new ApiResponse(0, data);
  }

}