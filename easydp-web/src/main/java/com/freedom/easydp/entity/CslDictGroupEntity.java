package com.freedom.easydp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * 字典编码分组
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
@JsonInclude(Include.NON_NULL)
public class CslDictGroupEntity extends BaseEntity {

  /**
   * 分组编码
   */
  private String code;

  /**
   * 分组名称
   */
  private String name;

  /**
   * 分组类型(0:字典,1:SQL)
   */
  private Integer type;

  /**
   * SQL语句
   */
  private String sql;

  /**
   * 描述信息
   */
  private String desc;

}
