package com.freedom.easydp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.freedom.easydp.generator.QuerySQL;
import com.freedom.easydp.utils.JsonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 数据连接信息
 *
 * @author nan.zhou
 * @date 2018-09-06
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Database extends BaseEntity {

  /**
   * 项目信息ID
   */
  private Long projectId;

  /**
   * 数据库类型(0:mysql,1:oracle)
   */
  private Integer dbType;

  /**
   * 驱动连接的URL
   */
  private String url;

  /**
   * 驱动名称
   */
  private String driver;

  /**
   * 数据库连接用户名
   */
  private String username;

  /**
   * 数据库连接密码
   */
  private String password;

  /**
   * 表前缀
   */
  private String tablePrefix;

  /**
   * 忽略字段(json数组)
   */
  private String ignoreField;

}
