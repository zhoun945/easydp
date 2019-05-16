package com.freedom.easydp.generator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freedom.easydp.entity.Project;
import com.freedom.easydp.entity.Table;
import com.freedom.easydp.utils.JsonUtil;
import java.io.File;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * com.freedom.easydp.generator
 *
 * @author nan.zhou
 * @date 2018-09-13
 */
public class CodeGenerator {

  public static QuerySQL getQuerySQL(Integer dbType) {
    if (dbType == 0) {
      return QuerySQL.MYSQL;
    } else if (dbType == 1) {
      return QuerySQL.ORACLE;
    }
    return null;
  }

  public static List<String> getIgnoreFieldList(String ignoreField) {
    List<String> ignoreFieldList = new ArrayList<>();
    if (ignoreField == null) {
      return ignoreFieldList;
    }

    try {
      ignoreFieldList = JsonUtil.jsonToList(ignoreField, new TypeReference<List<String>>(){});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ignoreFieldList;
  }

  public static String getEntityName(String tablePrefix, String tableName) {
    String[] camelArray = tableName.toLowerCase().split("_");
    int start = 0;
    if (StringUtils.isNotEmpty(tablePrefix)) {
      start = 1;
    }

    StringBuilder result = new StringBuilder();
    for (int i = start; i < camelArray.length; i++) {
      result.append(capitalFirst(camelArray[i]));
    }
    return result.toString();
  }

  public static String getLowerCaseEntityName(String entityName) {
    String result = entityName
        .replaceFirst(entityName.substring(0, 1), entityName.substring(0, 1).toLowerCase());
    return result;
  }

  public static String capitalFirst(String name) {
    char[] array = name.toCharArray();
    array[0] -= 32;
    return String.valueOf(array);
  }

  public static String getFieldName(String columnName) {
    String[] camelArray = columnName.toLowerCase().split("_");
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < camelArray.length; i++) {
      if (result.length() == 0) {
        result.append(camelArray[i]);
      } else {
        result.append(capitalFirst(camelArray[i]));
      }
    }
    return result.toString();
  }

  public static String getFieldType(Integer dbType, String columnType) {
    if (dbType == 0) {
      return processMySqlType(columnType);
    } else if (dbType == 1) {
      return processOracleType(columnType);
    }
    return null;
  }

  /**
   * MYSQL字段类型转换
   *
   * @param type
   *            字段类型
   * @return JAVA类型
   */
  private static String processMySqlType(String type) {
    String t = type.toLowerCase();
    if (t.contains("char") || t.contains("text")) {
      return "String";
    } else if (t.contains("bigint")) {
      return "Long";
    } else if (t.contains("int")) {
      return "Integer";
    } else if (t.contains("date") || t.contains("time") || t.contains("year")) {
      return "Date";
    } else if (t.contains("text")) {
      return "String";
    } else if (t.contains("bit")) {
      return "Boolean";
    } else if (t.contains("decimal")) {
      return "BigDecimal";
    } else if (t.contains("blob")) {
      return "byte[]";
    } else if (t.contains("float")) {
      return "Float";
    } else if (t.contains("double")) {
      return "Double";
    } else if (t.contains("json") || t.contains("enum")) {
      return "String";
    }
    return "String";
  }

  /**
   * ORACLE字段类型转换
   *
   * @param type
   *            字段类型
   * @return JAVA类型
   */
  private static String processOracleType(String type) {
    String t = type.toUpperCase();
    if (t.contains("CHAR")) {
      return "String";
    } else if (t.contains("DATE") || t.contains("TIMESTAMP")) {
      return "Date";
    } else if (t.contains("NUMBER")) {
      if (t.matches("NUMBER\\(+\\d{1}+\\)")) {
        return "Integer";
      } else if (t.matches("NUMBER\\(+\\d{2}+\\)")) {
        return "Long";
      }
      return "Double";
    } else if (t.contains("FLOAT")) {
      return "Float";
    } else if (t.contains("BLOB")) {
      return "Object";
    } else if (t.contains("RAW")) {
      return "byte[]";
    }
    return "String";
  }

  public static String getCommentType(String javaType) {
    if (javaType.equals("String") || javaType.equals("Date")) {
      return "string";
    } else if (javaType.equals("Integer") || javaType.equals("Long") || javaType.equals("Float")
        || javaType.equals("Double") || javaType.equals("BigDecimal")) {
      return "number";
    } else if (javaType.equals("Boolean")) {
      return "boolean";
    } else {
      return "object";
    }
  }

  public static VelocityEngine createEngine() {
    Properties properties = new Properties();
    properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    properties.setProperty(Velocity.RESOURCE_LOADER, "file");
    properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
    properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
    properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
    return new VelocityEngine(properties);
  }

  public static Map<String, String> getTemplateMap(Project project, Table table) {
    String applicationName = project.getArtifactId();
    String applicationPath = "d:/tmp/generator/" + applicationName;
    String modulePath = applicationPath + "/" + applicationName + "-web";
    String srcPath = modulePath + "/src/java";
    String packagePath = srcPath + String.join("/", project.getGroupId().split("."));

    String entityPath = packagePath + "/entity"; mkdirs(entityPath);
    String mapperPath = packagePath + "/mapper"; mkdirs(mapperPath);
    String xmlPath = packagePath + "/mapper/xml"; mkdirs(xmlPath);
    String servicePath = packagePath + "/service"; mkdirs(servicePath);
    String serviceImplPath = packagePath + "/service/impl"; mkdirs(serviceImplPath);
    String controllerPath = packagePath + "/controller"; mkdirs(controllerPath);

    String entityClassPath = entityPath + "/" + table.getEntityName() + ".java";
    String mapperClassPath = mapperPath + "/" + table.getEntityName() + "Mapper.java";
    String xmlClassPath = xmlPath + "/" + table.getEntityName() + "Mapper.xml";
    String serviceClassPath = servicePath + "/" + table.getEntityName() + "Service.java";
    String serviceClassImplPath = serviceImplPath + "/" + table.getEntityName() + "ServiceImpl.java";
    String controllerClassPath = controllerPath + "/" + table.getEntityName() + "Controller.java";

    String entityTemplate = "/template/entity.java.vm";
    String mapperTemplate = "/template/mapper.java.vm";
    String xmlTemplate = "/template/mapper.xml.vm";
    String serviceTemplate = "/template/service.java.vm";
    String serviceImplTemplate = "/template/serviceImpl.java.vm";
    String controllerTemplate = "/template/controller.java.vm";

    Map<String, String> map = new HashMap<>();
    map.put(entityTemplate, entityClassPath);
    map.put(mapperTemplate, mapperClassPath);
    map.put(xmlTemplate, xmlClassPath);
    map.put(serviceTemplate, serviceClassPath);
    map.put(serviceImplTemplate, serviceClassImplPath);
    map.put(controllerTemplate, controllerClassPath);
    return map;
  }

  private static void mkdirs(String path) {
    File dir = new File(path);
    if (!dir.exists()) {
      dir.mkdirs();
    }
  }

}
