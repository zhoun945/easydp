package com.freedom.easydp.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 表信息
 *
 * @author nan.zhou
 * @date 2018-09-06
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Table extends BaseEntity {

  /**
   * 数据库表名
   */
  private String tableName;

  /**
   * 数据库表注释
   */
  private String comment;

  /**
   * 实体类名称
   */
  private String entityName;

  /**
   * 实体类名称(首字母小写)
   */
  private String lowerCaseEntityName;

  /**
   * 列信息
   */
  private List<Column> columnList;

  /**
   * 日期
   */
  private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

}
