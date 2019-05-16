package com.freedom.easydp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

/**
 * 项目信息
 *
 * @author nan.zhou
 * @date 2018-09-10
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Project extends BaseEntity {

  /**
   * 项目名称
   */
  private String name;

  /**
   * Group
   */
  private String groupId;

  /**
   * Artifact
   */
  private String artifactId;

  /**
   * 作者/邮箱
   */
  private String author;

  /**
   * 描述
   */
  private String desc;

  /**
   * 当前日期
   */
  private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

}
