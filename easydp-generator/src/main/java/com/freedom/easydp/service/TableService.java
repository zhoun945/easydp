package com.freedom.easydp.service;

import com.freedom.easydp.entity.Table;
import com.freedom.easydp.support.ApiResponse;
import java.util.List;

/**
 * 表信息 Service
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
public interface TableService extends BaseService<Table, Long> {

  /**
   * 生成代码
   *
   * @param projectId 项目ID
   * @param databaseId 数据源ID
   * @param tableList 表列表
   * @return
   */
  ApiResponse<Boolean> generate(Long projectId, Long databaseId, List<Table> tableList);

}
