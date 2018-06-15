package com.freedom.easydp.service;

import com.freedom.easydp.support.ApiResponse;
import com.github.pagehelper.PageInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Service 基类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
public interface BaseService<T extends Serializable, I> {

  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> save(T entity);


  /**
   * <p>
   * 插入一条记录（选择字段，null 字段不插入）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> saveSelective(T entity);


  /**
   * <p>
   * 插入（批量）
   * </p>
   *
   * @param entityList 实体对象列表
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> saveSelectiveBatch(List<T> entityList);


  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> deleteById(I id);

  /**
   * <p>
   * 根据 ID 删除（逻辑删除）
   * </p>
   *
   * @param id 主键ID
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> deleteByIdLogic(I id);


  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 删除条件（key：字段名，val：字段值）
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> deleteByMap(Map<String, Object> columnMap);


  /**
   * <p>
   * 删除（根据ID 批量删除）
   * </p>
   *
   * @param idList 主键ID列表
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> deleteBatchIds(List<I> idList);


  /**
   * <p>
   * 根据 ID 修改
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> update(T entity);


  /**
   * <p>
   * 根据 ID 选择修改（null字段不更新）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> updateSelective(T entity);

  /**
   * <p>
   * 根据 ID 修改（乐观锁，null字段不更新）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> updateSelectiveByOptimisticLock(T entity);


  /**
   * <p>
   * 实体列表批量更新
   * </p>
   *
   * @param entityList 实体对象列表
   * @return int  影响的记录数量
   */
  ApiResponse<Boolean> updateSelectiveBatch(List<T> entityList);


  /**
   * <p>
   * 根据 ID 查询实体对象
   * </p>
   *
   * @param id 主键ID
   * @return T    实体类
   */
  ApiResponse<T> find(I id);


  /**
   * <p>
   * 根据 ID 查询 MAP
   * </p>
   *
   * @param id 主键ID
   * @return Map<String ,   Object>
   */
  ApiResponse<Map<String, Object>> findMap(I id);


  /**
   * <p>
   * 根据 columnMap 查询实体对象
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return T    实体类
   */
  ApiResponse<T> find(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 查询 MAP
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return Map<String ,   Object>
   */
  ApiResponse<Map<String, Object>> findMap(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询实体列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return List<T>   实体列表
   */
  ApiResponse<List<T>> findList(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询 MAP LIST
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return List<Map < String ,   Object>>
   */
  ApiResponse<List<Map<String, Object>>> findMapList(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询实体分页列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @param pageNum 页码
   * @param pageSize 每页数量
   * @return Page<T> 实体分页列表
   */
  ApiResponse<PageInfo<T>> findPage(Integer pageNum, Integer pageSize, Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询Map分页列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @param pageNum 页码
   * @param pageSize 每页数量
   * @return Page<Map < String ,   Object>>
   */
  ApiResponse<PageInfo<Map<String, Object>>> findMapPage(Integer pageNum,
      Integer pageSize, Map<String, Object> columnMap);

}
