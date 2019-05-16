package com.freedom.easydp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * 字段信息
 *
 * @author nan.zhou
 * @date 2018-09-06
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Column extends BaseEntity {

  /**
   * 字段名称
   */
  private String columnName;

  /**
   * 字段类型
   */
  private String columnType;

  /**
   * 属性名称
   */
  private String fieldName;

  /**
   * 属性类型
   */
  private String fieldType;

  /**
   * 注释类型
   */
  private String commentType;

  /**
   * 注释
   */
  private String comment;

}
