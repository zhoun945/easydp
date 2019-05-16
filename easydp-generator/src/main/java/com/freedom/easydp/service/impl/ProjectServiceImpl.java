package com.freedom.easydp.service.impl;

import com.freedom.easydp.entity.Project;
import com.freedom.easydp.mapper.ProjectMapper;
import com.freedom.easydp.service.BaseServiceImpl;
import com.freedom.easydp.service.ProjectService;
import org.springframework.stereotype.Service;

/**
 * 项目信息 ServiceImpl
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper, Project, Long> implements ProjectService {

}
