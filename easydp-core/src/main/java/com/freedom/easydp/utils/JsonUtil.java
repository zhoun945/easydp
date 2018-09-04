package com.freedom.easydp.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json工具类
 *
 * @author nan.zhou
 * @Date 2018-07-03
 */
public class JsonUtil {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
  private static ObjectMapper objectMapper = null;

  static {
    objectMapper = new ObjectMapper();
    // 空值不序列化
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //忽略目标对象没有的属性
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  /**
   * 对象转JSON字符串
   *
   * @param obj Bean/List
   */
  public static String objToJson(Object obj) throws JsonProcessingException {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

  /**
   * JSON字符串转对象
   *
   * @param json JSON格式字符串
   * @param clazz 转换的Class
   */
  public static <T> T jsonToBean(String json, Class<T> clazz) throws IOException {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }


  /**
   * JSON字符串转LIST
   *
   * @param json JSON格式字符串
   * @param typeRef 样例：new TypeReference<List<User>>(){}
   */
  public static <T> T jsonToList(String json, TypeReference<T> typeRef) throws IOException {
    try {
      return objectMapper.readValue(json, typeRef);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

  /**
   * JSON字符串转MAP
   *
   * @param json JSON格式字符串
   * @param typeRef 样例：new TypeReference<Map<String, User>>(){}
   * @return 对象
   */
  public static <T> T jsonToMap(String json, TypeReference<T> typeRef) throws IOException {
    try {
      return objectMapper.readValue(json, typeRef);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

  /**
   * JSON字符串转换为Map类型
   *
   * @param json JSON格式字符串
   * @return Map
   */
  public static Map jsonToMap(String json) throws IOException {
    try {
      return objectMapper.readValue(json, Map.class);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

  /**
   * 读取JSON文件转换为对象
   *
   * @param path 输入文件路径
   * @param clazz 对象类型
   * @return 对象
   */
  public static <T> T readJsonFile(String path, Class<T> clazz) throws IOException {
    try {
      return objectMapper.readValue(new File(path), clazz);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }


  /**
   * 读取JSON文件转换为 Map
   *
   * @param path 输入文件路径
   * @param typeRef 样例：new TypeReference<Map<String, User>>(){}
   * @param <T> 实体类
   * @return 实体类
   */
  public static <T> T readJsonFile(String path, TypeReference<T> typeRef) throws IOException {
    try {
      return objectMapper.readValue(new File(path), typeRef);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

  /**
   * 将对象以JSON格式写入文件
   *
   * @param path 输出文件路径
   * @param obj 对象
   */
  public static void writeJsonFile(String path, Object obj) throws IOException {
    try {
      objectMapper.writeValue(new File(path), obj);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
      throw e;
    }
  }

}
