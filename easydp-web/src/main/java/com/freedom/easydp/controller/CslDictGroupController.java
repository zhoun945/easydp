package com.freedom.easydp.controller;

import com.freedom.easydp.entity.CslDictGroupEntity;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.Condition;
import com.freedom.easydp.service.CslDictGroupService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
   * @api {get} /csl/dict/group 分页查询
   * @apiVersion 1.0.0
   * @apiDescription 字典编码分组 - 分页查询
   * @apiGroup csl/dict/group
   *
   * @apiParam {number} [pageNum=1] 页码
   * @apiParam {number} [pageSize=15] 每页数量
   * @apiParam {number} [type=all] 分组类型(0:字典,1:SQL)
   * @apiParamExample {string} 请求参数格式
   * ?pageNum=1&pageSize=10&type=0
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {object} data 返回内容
   * @apiSuccess {number} data.total 数据总数
   * @apiSuccess {number} data.pages 页码总数
   * @apiSuccess {array} data.list 数据列表
   * @apiSuccess {number} data.list[i].code 分组编码
   * @apiSuccess {number} data.list[i].name 分组名称
   * @apiSuccess {number} data.list[i].type 分组类型(0:字典,1:SQL)
   * @apiSuccess {number} data.list[i].sql SQL
   * @apiSuccess {number} data.list[i].desc 描述
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":{"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"total":17,"pages":2,"list":[{"id":13,"createUser":-1,"updateUser":-1,"createTime":null,"updateTime":null,"code":"RANK_LEVEL","name":"职级（查询）","type":0,"sql":null,"desc":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"firstPage":1,"lastPage":2}}
   */
  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ApiResponse<PageInfo<CslDictGroupEntity>> queryPage(
      @RequestParam(required = false) Integer pageNum,
      @RequestParam(required = false) Integer pageSize,
      @RequestParam(required = false) Integer type) {
    return cslDictGroupService.findPage(pageNum, pageSize,
        new Condition("type", type).asMap());
  }


}
