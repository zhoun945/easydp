package com.freedom.easydp.support;

import com.freedom.easydp.entity.BaseEntity;
import com.freedom.easydp.exception.ServiceException;
import java.util.Date;

/**
 * 属性工具类
 *
 * @author nan.zhou
 * @Date 2018-03-15
 */
public class ParamInjector {

  /**
   * 公共属性注入
   *
   * @param entity  实体类
   * @param <E> 必须继承BaseEntity
   * @return
   */
  public static <E extends BaseEntity> E injectProperty(E entity) {
    if (entity == null) {
      throw ServiceException.biz("param is null");
    }

    Date now = new Date();
    Long id = UserThreadLocal.getUser().getId();
    entity.setCreateUser(id);
    entity.setUpdateUser(id);
    entity.setCreateTime(now);
    entity.setUpdateTime(now);
    return entity;
  }

}
