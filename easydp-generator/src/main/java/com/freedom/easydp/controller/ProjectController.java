package com.freedom.easydp.controller;

import com.freedom.easydp.entity.Project;
import com.freedom.easydp.service.ProjectService;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.Condition;
import com.freedom.easydp.support.ParamInjector;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/cg/project")
public class ProjectController extends BaseController {

  @Autowired
  private ProjectService projectService;

  /**
   * @api {get} /cg/project/page 分页查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 分页查询
   * @apiGroup cg/project
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
  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ApiResponse<PageInfo<Project>> findPage(
      @RequestParam(required = false) Integer pageNum,
      @RequestParam(required = false) Integer pageSize,
      @RequestParam(required = false) String name) {

    Condition condition =
        new Condition()
            .put("name", name);
    return projectService.findPage(pageNum, pageSize, condition.asMap());
  }

  /**
   * @api {get} /cg/project/info 详情查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 详情查询
   * @apiGroup cg/project
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
  public ApiResponse<Project> find(@PathVariable("id") Long id) {
    return projectService.find(id);
  }

  /**
   * @api {post} /cg/project/save 保存信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 保存信息
   * @apiGroup cg/project
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
  public ApiResponse<Boolean> save(@RequestBody Project cslDictGroup) {
    ParamInjector.injectProperty(cslDictGroup);
    return projectService.save(cslDictGroup);
  }

  /**
   * @api {post} /cg/project/update 更新信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 更新信息
   * @apiGroup cg/project
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
  public ApiResponse<Boolean> update(@RequestBody Project cslDictGroup) {
    ParamInjector.injectProperty(cslDictGroup);
    return projectService.update(cslDictGroup);
  }

  /**
   * @api {post} /cg/project/delete 删除信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 删除信息
   * @apiGroup cg/project
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
    return projectService.deleteById(id);
  }

}
