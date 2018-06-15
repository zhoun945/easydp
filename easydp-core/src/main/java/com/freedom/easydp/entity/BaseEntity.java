package com.freedom.easydp.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 实体类基类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
public class BaseEntity implements Serializable {

  /**
   * 主键,自增
   */
  protected Long id;
  /**
   * 创建人(-1表示系统内置)
   */
  protected Long createUser;
  /**
   * 更新人(-1表示系统内置)
   */
  protected Long updateUser;
  /**
   * 创建时间
   */
  protected Date createTime;
  /**
   * 更新时间
   */
  protected Date updateTime;

}
