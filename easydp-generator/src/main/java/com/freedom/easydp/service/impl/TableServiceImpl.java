package com.freedom.easydp.service.impl;

import com.freedom.easydp.entity.Column;
import com.freedom.easydp.entity.Database;
import com.freedom.easydp.entity.Project;
import com.freedom.easydp.entity.Table;
import com.freedom.easydp.generator.CodeGenerator;
import com.freedom.easydp.mapper.TableMapper;
import com.freedom.easydp.service.BaseServiceImpl;
import com.freedom.easydp.service.ColumnService;
import com.freedom.easydp.service.DatabaseService;
import com.freedom.easydp.service.ProjectService;
import com.freedom.easydp.service.TableService;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.utils.ExceptionUtil;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 表信息 ServiceImpl
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@Service
public class TableServiceImpl extends BaseServiceImpl<TableMapper, Table, Long> implements TableService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ProjectService projectService;

  @Autowired
  private DatabaseService databaseService;

  @Autowired
  private ColumnService columnService;

  public void generate(Project project, Database database, Table table) {
    try {
      List<Column> columnList = columnService.queryColumnList(database, table.getTableName()).getData();
      String entityName = CodeGenerator.getEntityName(database.getTablePrefix(), table.getTableName());
      table.setEntityName(entityName);
      table.setLowerCaseEntityName(CodeGenerator.getLowerCaseEntityName(entityName));
      table.setColumnList(columnList);

      VelocityContext velocityContext = new VelocityContext();
      velocityContext.put("project", project);
      velocityContext.put("table", table);

      VelocityEngine velocityEngine = CodeGenerator.createEngine();
      Map<String, String> templateMap = CodeGenerator.getTemplateMap(project, table);
      for (Map.Entry<String, String> entry : templateMap.entrySet()) {
        Template template = velocityEngine.getTemplate(entry.getKey(), "UTF-8");
        FileOutputStream fos = new FileOutputStream(entry.getValue());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        template.merge(velocityContext, writer);
        writer.close();
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      ExceptionUtil.handleException(e);
    }
  }

  @Override
  public ApiResponse<Boolean> generate(Long projectId, Long databaseId, List<Table> tableList) {
    Project project = projectService.find(projectId).getData();
    Database database = databaseService.find(databaseId).getData();
    for (Table table : tableList) {
      generate(project, database, table);
    }
    return null;
  }

}
