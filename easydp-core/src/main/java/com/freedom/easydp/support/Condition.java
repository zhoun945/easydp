package com.freedom.easydp.support;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * 数据库操作条件
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
public class Condition {

  private Map<String, Object> condition = new LinkedHashMap<>();

  public Condition() {}

  public Condition(String key, Object value) {
    condition.put(key, value);
  }

  public Condition put(String key, Object value) {
    condition.put(key, value);
    return this;
  }

  public Map<String, Object> asMap() {
    return condition;
  }

  public static Map<String, Object> emptyMap() {
    return new LinkedHashMap<>();
  }

}
