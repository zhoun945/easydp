package com.freedom.easydp.service;

import com.freedom.easydp.exception.ServiceException;
import com.freedom.easydp.mapper.BaseMapper;
import com.freedom.easydp.support.ApiResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service 基类实现类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<M extends BaseMapper<T, I>, T extends Serializable, I> implements
    BaseService<T, I> {

  @Autowired
  protected M mapper;

  @Autowired
  private MessageSource messageSource;

  @Override
  public ApiResponse<Boolean> save(T entity) {
    int effectRows = mapper.save(entity);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.save");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> saveSelective(T entity) {
    int effectRows = mapper.saveSelective(entity);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.save");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> saveSelectiveBatch(List<T> entityList) {
    int effectRows = mapper.saveSelectiveBatch(entityList);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.save");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> deleteById(I id) {
    int effectRows = mapper.deleteById(id);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.delete");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> deleteByIdLogic(I id) {
    int effectRows = mapper.deleteByIdLogic(id);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.delete");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> deleteByMap(Map<String, Object> columnMap) {
    int effectRows = mapper.deleteByMap(columnMap);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.delete");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> deleteBatchIds(List<I> idList) {
    int effectRows = mapper.deleteBatchIds(idList);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.delete");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> update(T entity) {
    int effectRows = mapper.update(entity);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.update");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> updateSelective(T entity) {
    int effectRows = mapper.updateSelective(entity);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.update");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> updateSelectiveByOptimisticLock(T entity) {
    int effectRows = mapper.updateSelectiveByOptimisticLock(entity);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.update");
    }
    return new ApiResponse().success();
  }


  @Override
  public ApiResponse<Boolean> updateSelectiveBatch(List<T> entityList) {
    int effectRows = mapper.updateSelectiveBatch(entityList);
    if (effectRows < 1) {
      throw ServiceException.sys(messageSource, "error.sys.update");
    }
    return new ApiResponse().success();
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<T> find(I id) {
    T t = mapper.find(id);
    return new ApiResponse().success(t);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<Map<String, Object>> findMap(I id) {
    Map<String, Object> map = mapper.findMap(id);
    return new ApiResponse().success(map);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<T> find(Map<String, Object> columnMap) {
    T t = mapper.find(columnMap);
    return new ApiResponse().success(t);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<Map<String, Object>> findMap(Map<String, Object> columnMap) {
    Map<String, Object> map = mapper.findMap(columnMap);
    return new ApiResponse().success(map);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<List<T>> findList(Map<String, Object> columnMap) {
    List<T> list = mapper.findList(columnMap);
    return new ApiResponse().success(list);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<List<Map<String, Object>>> findMapList(Map<String, Object> columnMap) {
    List<Map<String, Object>> list = mapper.findMapList(columnMap);
    return new ApiResponse().success(list);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<PageInfo<T>> findPage(Integer pageNum,
      Integer pageSize, Map<String, Object> columnMap) {

    pageNum = (pageNum == null) ? 1 : pageNum;
    pageSize = (pageSize == null) ? 15 : pageSize;
    PageHelper.startPage(pageNum, pageSize);
    Page<T> list = mapper.findPage(columnMap);
    PageInfo page = new PageInfo(list);
    return new ApiResponse().success(page);
  }


  @Override
  @Transactional(readOnly = true, rollbackFor = Exception.class)
  public ApiResponse<PageInfo<Map<String, Object>>> findMapPage(Integer pageNum,
      Integer pageSize, Map<String, Object> columnMap) {
    pageNum = (pageNum == null) ? 1 : pageNum;
    pageSize = (pageSize == null) ? 15 : pageSize;
    PageHelper.startPage(pageNum, pageSize);
    Page<Map<String, Object>> list = mapper.findMapPage(columnMap);
    PageInfo page = new PageInfo(list);
    return new ApiResponse().success(page);
  }

}
