package com.freedom.easydp.generator;

import com.freedom.easydp.entity.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
public class DBConnection {

  private String driver, url, username, password;
  private Connection con = null;

  public DBConnection(Database database) {
    this.driver = database.getDriver();
    this.url = database.getUrl();
    this.username = database.getUsername();
    this.password = database.getPassword();
  }

  public DBConnection(String driver, String url, String username, String password) {
    this.driver = driver;
    this.url = url;
    this.username = username;
    this.password = password;
  }

  /**
   * 打开连接
   */
  public Connection openConnection() throws ClassNotFoundException, SQLException {
    if (con == null || con.isClosed()) {
      Class.forName(driver);
      con = DriverManager.getConnection(url, username, password);
    }
    return con;
  }

  /**
   * 关闭连接
   */
  public void closeConnection() throws SQLException {
    try {
      if (con != null) {
        con.close();
      }
    } finally {
      con = null;
      System.gc();
    }
  }

  /**
   * 使用Statement对象查询数据集合
   */
  public List<Map<String, Object>> findMapList(String sql)
      throws SQLException {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    Statement st = null;
    ResultSet rs = null;
    try {
      st = con.createStatement();
      rs = st.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      while (rs != null && rs.next()) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < columnCount; i++) {
          String name = rsmd.getColumnLabel(i + 1);
          Object value = rs.getObject(name);
          map.put(name, value);
        }
        list.add(map);
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (st != null) {
        st.close();
      }
    }
    return list;
  }

}
