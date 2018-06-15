package com.freedom.easydp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller 基类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
public class BaseController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 直接输出流文件
   */
  protected String renderFile(HttpServletResponse response, File file)
      throws FileNotFoundException {
    if (file == null) {
      logger.error("下载文件失败, 未找到的文件[file=null]");
      throw new FileNotFoundException();
    }
    return renderFile(response, file.getName(), file);
  }

  /**
   * 直接输出流文件
   */
  protected String renderFile(HttpServletResponse response, String fileName, File file) {
    ServletOutputStream os = null;
    InputStream is = null;
    try {
      fileName = new String(fileName.getBytes(), "ISO8859-1");
      response.setContentType("application/octet-stream");
      response.setHeader("Content-disposition", "attachment;filename=" + fileName);

      os = response.getOutputStream();
      is = new FileInputStream(file);
      byte[] buffer = new byte[2048];
      int n = 0;
      while ((n = is.read(buffer, 0, buffer.length)) != -1) {
        os.write(buffer, 0, n);
      }
    } catch (UnsupportedEncodingException e) {
      logger.error("下载文件失败, 文件名编码转换错误", e);
    } catch (FileNotFoundException e) {
      logger.error("下载文件失败, 未找到的文件", e);
    } catch (IOException e) {
      logger.error("下载文件失败, 文件输出失败", e);
    } finally {
      try {
        os.flush();
        os.close();
        is.close();
      } catch (IOException e) {
        logger.error("关闭流失败", e);
      }
    }
    return null;
  }
}
