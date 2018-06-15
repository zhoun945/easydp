package com.freedom.easydp.mapper;

import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Mapper 基类
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
public interface BaseMapper<T extends Serializable, I> {


  /**
   * <p>
   * 插入一条记录
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  int save(T entity);


  /**
   * <p>
   * 插入一条记录（选择字段，null 字段不插入）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  int saveSelective(T entity);


  /**
   * <p>
   * 插入（批量）（null值不插入）
   * 因为绝大多数的业务需求是想如果字段为null那么按照数据库的默认字段来存储
   * </p>
   *
   * @param entityList 实体对象列表
   * @return int  影响的记录数量 -> 总是=1？因为是按照;分隔一条条的插入，而不是按照values后多对括号的方式插入的
   */
  int saveSelectiveBatch(List<T> entityList);


  /**
   * <p>
   * 根据 ID 删除
   * </p>
   *
   * @param id 主键ID
   * @return int  影响的记录数量
   */
  int deleteById(I id);

  /**
   * <p>
   * 根据 ID 删除（逻辑删除）
   * </p>
   *
   * @param id 主键ID
   * @return int  影响的记录数量
   */
  int deleteByIdLogic(I id);


  /**
   * <p>
   * 根据 columnMap 条件，删除记录
   * </p>
   *
   * @param columnMap 删除条件（key：字段名，val：字段值）
   * @return int  影响的记录数量
   */
  int deleteByMap(Map<String, Object> columnMap);


  /**
   * <p>
   * 删除（根据ID 批量删除）
   * </p>
   *
   * @param idList 主键ID列表
   * @return int  影响的记录数量
   */
  int deleteBatchIds(List<I> idList);


  /**
   * <p>
   * 根据 ID 修改
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  int update(T entity);


  /**
   * <p>
   * 根据 ID 修改（null字段不更新）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  int updateSelective(T entity);


  /**
   * <p>
   * 根据 ID 修改（乐观锁，null字段不更新）
   * </p>
   *
   * @param entity 实体对象
   * @return int  影响的记录数量
   */
  int updateSelectiveByOptimisticLock(T entity);


  /**
   * <p>
   * 根据 ID 批量修改（null字段不更新）
   * </p>
   *
   * @param entityList 实体对象列表
   * @return int  影响的记录数量
   */
  int updateSelectiveBatch(List<T> entityList);


  /**
   * <p>
   * 根据 ID 查询实体对象
   * </p>
   *
   * @param id 主键ID
   * @return T    实体类
   */
  T find(I id);

  /**
   * <p>
   * 根据 ID 查询 Map
   * </p>
   *
   * @param id 主键ID
   * @return Map<String ,   Object>
   */
  Map<String, Object> findMap(I id);


  /**
   * <p>
   * 根据 columnMap 查询实体对象
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return T    实体类
   */
  T find(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 查询 Map
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return Map<String ,   Object>
   */
  Map<String, Object> findMap(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询实体列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return List<T>   实体列表
   */
  List<T> findList(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询 Map List
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return List<Map < String ,   Object>>
   */
  List<Map<String, Object>> findMapList(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询实体分页列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return Page<T> 实体分页列表
   */
  Page<T> findPage(Map<String, Object> columnMap);


  /**
   * <p>
   * 根据 columnMap 条件查询Map分页列表
   * </p>
   *
   * @param columnMap 查询条件（key：字段名，val：字段值）
   * @return Page<Map < String ,   Object>>
   */
  Page<Map<String, Object>> findMapPage(Map<String, Object> columnMap);

}
