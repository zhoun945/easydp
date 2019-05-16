package com.freedom.easydp.service.impl;

import com.freedom.easydp.entity.Column;
import com.freedom.easydp.entity.Database;
import com.freedom.easydp.generator.CodeGenerator;
import com.freedom.easydp.generator.DBConnection;
import com.freedom.easydp.mapper.ColumnMapper;
import com.freedom.easydp.service.BaseServiceImpl;
import com.freedom.easydp.service.ColumnService;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.utils.ExceptionUtil;
import com.freedom.easydp.utils.ObjectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 列信息 ServiceImpl
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@Service
public class ColumnServiceImpl extends BaseServiceImpl<ColumnMapper, Column, Long> implements ColumnService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public ApiResponse<List<Column>> queryColumnList(Database database, String tableName) {
    try {
      DBConnection dbConnection = new DBConnection(database);
      dbConnection.openConnection();
      String sql = CodeGenerator.getQuerySQL(database.getDbType()).getColumnSql(tableName);
      List<Map<String, Object>> columnMapList = dbConnection.findMapList(sql);
      dbConnection.closeConnection();

      //-----------------------------------------
      List<String> ignoreFieldList = CodeGenerator.getIgnoreFieldList(database.getIgnoreField());
      List<Column> columnList = new ArrayList<>();
      for (Map<String, Object> columnMap : columnMapList) {
        String columnName = ObjectUtil.getString(columnMap.get("Field"));
        String columnType = ObjectUtil.getString(columnMap.get("Type"));
        String comment = ObjectUtil.getString(columnMap.get("Comment"));
        String fieldName = CodeGenerator.getFieldName(columnName);
        String fieldType = CodeGenerator.getFieldType(database.getDbType(), columnType);

        if (!ignoreFieldList.contains(columnName)) {
          Column column = new Column();
          column.setColumnName(columnName);
          column.setColumnType(columnType);
          column.setFieldName(fieldName);
          column.setFieldType(fieldType);
          column.setComment(comment);
          column.setCommentType(CodeGenerator.getCommentType(fieldType));
          columnList.add(column);
        }
      }
      return new ApiResponse<>().success(columnList);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      ExceptionUtil.handleException(e);
    }
    return null;
  }

}
