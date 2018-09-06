package com.freedom.easydp.controller;

import com.freedom.easydp.entity.CslDictGroupEntity;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.Condition;
import com.freedom.easydp.service.CslDictGroupService;
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
 * 字典编码分组 Controller
 *
 * @author nan.zhou
 * @date 2018-06-11
 */
@RestController
@RequestMapping("/csl/dict/group")
public class CslDictGroupController extends BaseController {

  @Autowired
  private CslDictGroupService cslDictGroupService;

  /**
   * @api {get} /csl/dict/group/page 分页查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 分页查询
   * @apiGroup csl/dict/group
   *
   * @apiParam {number} [pageNum=1] 页码
   * @apiParam {number} [pageSize=15] 每页数量
   * @apiParam {number} [type=null] 分组类型(0:字典,1:SQL)
   * @apiParam {string} [code=null] 分组编码
   * @apiParamExample {string} 请求参数格式
   * ?pageNum=1&pageSize=10&type=0
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {object} data 返回内容
   * @apiSuccess {number} data.total 数据总数
   * @apiSuccess {number} data.pages 页码总数
   * @apiSuccess {array} data.list 数据列表
   * @apiSuccess {number} data.list.id ID
   * @apiSuccess {number} data.list.code 分组编码
   * @apiSuccess {number} data.list.name 分组名称
   * @apiSuccess {number} data.list.type 分组类型(0:字典,1:SQL)
   * @apiSuccess {number} data.list.desc 描述
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":{"total":1,"list":[{"id":1001,"code":"yes_no","name":"是/否","type":0,"desc":"是/否"}]}}
   */
  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ApiResponse<PageInfo<CslDictGroupEntity>> findPage(
      @RequestParam(required = false) Integer pageNum,
      @RequestParam(required = false) Integer pageSize,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = false) Integer code) {

    Condition condition =
        new Condition()
            .put("type", type)
            .put("code", code);
    return cslDictGroupService.findPage(pageNum, pageSize, condition.asMap());
  }

  /**
   * @api {get} /csl/dict/group/info 详情查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 详情查询
   * @apiGroup csl/dict/group
   *
   * @apiParam {number} id ID
   * @apiParamExample {string} 请求参数格式
   * /{id}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {object} data 返回内容
   * @apiSuccess {number} data.id ID
   * @apiSuccess {number} data.code 分组编码
   * @apiSuccess {number} data.name 分组名称
   * @apiSuccess {number} data.type 分组类型(0:字典,1:SQL)
   * @apiSuccess {number} data.sql SQL
   * @apiSuccess {number} data.desc 描述
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":{"id":1001,"code":"yes_no","name":"是/否","type":0,"desc":"是/否"}}
   */
  @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
  public ApiResponse<CslDictGroupEntity> find(@PathVariable("id") Long id) {
    return cslDictGroupService.find(id);
  }

  /**
   * @api {post} /csl/dict/group/save 保存信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 保存信息
   * @apiGroup csl/dict/group
   *
   * @apiParam {number} id ID
   * @apiParam {number} type 分组类型(0:字典,1:SQL)
   * @apiParam {string} code 分组编码
   * @apiParam {string} name 分组名称
   * @apiParam {string} [sql=null] SQL
   * @apiParam {string} [desc=null] 描述
   * @apiParamExample {json} 请求参数格式
   * {"type":0,"code":"yes_no","name":"是/否","sql":null,"desc":"是/否"}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ApiResponse<Boolean> save(@RequestBody CslDictGroupEntity cslDictGroup) {
    ParamInjector.injectProperty(cslDictGroup);
    return cslDictGroupService.save(cslDictGroup);
  }

  /**
   * @api {post} /csl/dict/group/update 更新信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 更新信息
   * @apiGroup csl/dict/group
   *
   * @apiParam {number} id ID
   * @apiParam {string} name 分组名称
   * @apiParam {string} [sql=null] SQL
   * @apiParam {string} [desc=null] 描述
   * @apiParamExample {json} 请求参数格式
   * {"id":1001,"name":"是/否","sql":null,"desc":"是/否"}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ApiResponse<Boolean> update(@RequestBody CslDictGroupEntity cslDictGroup) {
    ParamInjector.injectProperty(cslDictGroup);
    return cslDictGroupService.update(cslDictGroup);
  }

  /**
   * @api {post} /csl/dict/group/delete 删除信息
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 删除信息
   * @apiGroup csl/dict/group
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
    return cslDictGroupService.deleteById(id);
  }

}
