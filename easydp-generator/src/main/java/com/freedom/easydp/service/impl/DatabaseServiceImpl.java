package com.freedom.easydp.service.impl;

import com.freedom.easydp.entity.Database;
import com.freedom.easydp.mapper.DatabaseMapper;
import com.freedom.easydp.service.BaseServiceImpl;
import com.freedom.easydp.service.DatabaseService;
import org.springframework.stereotype.Service;

/**
 * DB信息 ServiceImpl
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@Service
public class DatabaseServiceImpl extends BaseServiceImpl<DatabaseMapper, Database, Long> implements DatabaseService {

}
