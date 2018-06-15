package com.freedom.easydp.mapper;

import com.freedom.easydp.entity.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 默认 Mapper
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Mapper
public interface DefaultMapper extends BaseMapper<BaseEntity, Long> {

}
