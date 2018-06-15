package com.freedom.easydp.service.impl;

import com.freedom.easydp.entity.CslDictGroupEntity;
import com.freedom.easydp.mapper.CslDictGroupMapper;
import com.freedom.easydp.service.BaseServiceImpl;
import com.freedom.easydp.service.CslDictGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * 字典编码分组 ServiceImpl
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@Service
public class CslDictGroupServiceImpl extends
    BaseServiceImpl<CslDictGroupMapper, CslDictGroupEntity, Long> implements
    CslDictGroupService {

  @Autowired
  private MessageSource messageSource;

}
