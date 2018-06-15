package com.freedom.easydp.entity;

import lombok.Data;

/**
 * 用户实体基类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Data
public class UserEntity extends BaseEntity {

  /**
   * 登录用户名
   */
  private String username;
  /**
   * 真实姓名（昵称）
   */
  private String nickname;

}
