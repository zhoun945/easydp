package com.freedom.easydp.support;

import lombok.Data;

/**
 * com.freedom.agmap.support
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
public class ValidError {

  private String object;
  private String field;
  private Object rejectedValue;
  private String message;

}
