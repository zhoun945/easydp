package com.freedom.easydp.mapper;

import com.freedom.easydp.entity.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目信息 Mapper
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project, Long> {

}
