package com.freedom.easydp.controller;

import com.freedom.easydp.entity.Database;
import com.freedom.easydp.service.DatabaseService;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.Condition;
import com.freedom.easydp.support.ParamInjector;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目信息 Controller
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@RestController
@RequestMapping("/cg/database")
public class DatabaseController extends BaseController {

  @Autowired
  private DatabaseService databaseService;

  /**
   * @api {get} /cg/database/page 列表查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 分页查询
   * @apiGroup cg/database
   *
   * @apiParam {number} [pageNum=1] 页码
   * @apiParam {number} [pageSize=15] 每页数量
   * @apiParam {string} [name=null] 项目名称
   * @apiParamExample {string} 请求参数格式
   * ?pageNum=1&pageSize=10&name=XXXX
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {object} data 返回内容
   * @apiSuccess {number} data.total 数据总数
   * @apiSuccess {number} data.pages 页码总数
   * @apiSuccess {array} data.list 数据列表
   * @apiSuccess {number} data.list.id ID
   * @apiSuccess {string} data.list.name 分组名称
   * @apiSuccess {string} data.list.author 作者/邮箱
   * @apiSuccess {string} data.list.groupId 分组名称
   * @apiSuccess {string} data.list.artifactId 应用标识
   * @apiSuccess {string} data.list.desc 描述
   * @apiSuccessExample {json} 正确返回值
   * {}
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ApiResponse<List<Database>> findList(@RequestParam Integer projectId) {
    Condition condition =
        new Condition()
            .put("projectId", projectId);
    return databaseService.findList(condition.asMap());
  }

  /**
   * @api {get} /cg/database/info 详情查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 详情查询
   * @apiGroup cg/database
   *
   * @apiParam {number} id ID
   * @apiParamExample {string} 请求参数格式
   * /{id}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {object} data 返回内容
   * @apiSuccess {number} data.id ID
   * @apiSuccess {string} data.name 分组名称
   * @apiSuccess {string} data.author 作者/邮箱
   * @apiSuccess {string} data.groupId 分组名称
   * @apiSuccess {string} data.artifactId 应用标识
   * @apiSuccess {string} data.desc 描述
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":{"id":1001,"code":"yes_no","name":"是/否","type":0,"desc":"是/否"}}
   */
  @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
  public ApiResponse<Database> find(@PathVariable("id") Long id) {
    return databaseService.find(id);
  }

  /**
   * @api {post} /cg/database/save 保存信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 保存信息
   * @apiGroup cg/database
   *
   * @apiSuccess {string} name 分组名称
   * @apiSuccess {string} author 作者/邮箱
   * @apiSuccess {string} groupId 分组名称
   * @apiSuccess {string} artifactId 应用标识
   * @apiSuccess {string} [desc=null] 描述
   * @apiParamExample {json} 请求参数格式
   * {}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ApiResponse<Boolean> save(@RequestBody Database database) {
    ParamInjector.injectProperty(database);
    return databaseService.save(database);
  }

  /**
   * @api {post} /cg/database/update 更新信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 更新信息
   * @apiGroup cg/database
   *
   * @apiSuccess {string} name 分组名称
   * @apiSuccess {string} author 作者/邮箱
   * @apiSuccess {string} groupId 分组名称
   * @apiSuccess {string} artifactId 应用标识
   * @apiSuccess {string} [desc=null] 描述
   * @apiParamExample {json} 请求参数格式
   * {}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ApiResponse<Boolean> update(@RequestBody Database database) {
    ParamInjector.injectProperty(database);
    return databaseService.update(database);
  }

  /**
   * @api {post} /cg/database/delete 删除信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 删除信息
   * @apiGroup cg/database
   *
   * @apiParam {number} id ID
   * @apiParamExample {string} 请求参数格式
   * /{id}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public ApiResponse<Boolean> deleteById(@PathVariable("id") Long id) {
    return databaseService.deleteById(id);
  }

}
