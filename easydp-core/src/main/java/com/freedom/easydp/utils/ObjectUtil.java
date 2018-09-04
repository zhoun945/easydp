package com.freedom.easydp.utils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * ObjectUtil
 *
 * @author nan.zhou
 * @Date 2018-08-03
 */
public class ObjectUtil {

  public static String getString(Map m, Object key) {
    return getString(m.get(key));
  }

  public static Integer getInteger(Map m, Object key) {
    return getInteger(m.get(key));
  }

  public static Long getLong(Map m, Object key) {
    return getLong(m.get(key));
  }

  public static BigDecimal getBigDecimal(Map m, Object key) {
    return getBigDecimal(m.get(key));
  }

  public static BigDecimal getBigDecimal(Object o) {
    if (o == null) {
      return null;
    }
    BigDecimal bigDecimal = new BigDecimal(o.toString());
    return bigDecimal;
  }

  public static Double getDouble(Map m, Object key) {
    return getDouble(m.get(key));
  }

  public static String getString(Object o) {
    if (o == null) {
      return null;
    }
    return o.toString();
  }

  public static Integer getInteger(Object o) {
    if (o == null) {
      return null;
    }
    return Integer.parseInt(o.toString());
  }

  public static Long getLong(Object o) {
    if (o == null) {
      return null;
    }
    return Long.parseLong(o.toString());
  }

  public static Double getDouble(Object o) {
    if (o == null) {
      return null;
    }
    return Double.parseDouble(o.toString());
  }

}
