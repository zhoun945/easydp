package com.freedom.easydp.utils;

import java.math.BigDecimal;

/**
 * ObjectUtil
 *
 * @author nan.zhou
 * @date 2018-08-03
 */
public class ObjectUtil {

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

  public static BigDecimal getBigDecimal(Object o) {
    if (o == null) {
      return null;
    }
    return new BigDecimal(o.toString());
  }

}
