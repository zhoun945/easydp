package com.freedom.easydp.service;

import com.freedom.easydp.entity.Column;
import com.freedom.easydp.entity.Database;
import com.freedom.easydp.support.ApiResponse;
import java.util.List;

/**
 * 列信息 Service
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
public interface ColumnService extends BaseService<Column, Long> {

  /**
   * 查询列
   *
   * @param database
   * @param tableName
   * @return
   */
  ApiResponse<List<Column>> queryColumnList(Database database, String tableName);

}
