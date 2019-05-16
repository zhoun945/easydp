package com.freedom.easydp.controller;

import com.freedom.easydp.entity.Table;
import com.freedom.easydp.service.TableService;
import com.freedom.easydp.support.ApiResponse;
import com.freedom.easydp.support.Condition;
import com.freedom.easydp.support.ParamInjector;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 表信息 Controller
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
@RestController
@RequestMapping("/cg/table")
public class TableController extends BaseController {

  @Autowired
  private TableService tableService;

  /**
   * @api {get} /cg/table/list 列表查询
   * @apiVersion 1.0.0
   * @apiDescription 表信息 - 列表查询
   * @apiGroup cg/table
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {array} data 返回内容
   * @apiSuccess {string} data.tableName 数据库表名
   * @apiSuccess {string} data.comment 数据库表注释
   * @apiSuccessExample {json} 正确返回值
   * {}
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ApiResponse<List<Table>> findList(@RequestParam Long projectId) {
    Condition condition =
        new Condition()
            .put("projectId", projectId);
    return tableService.findList(condition.asMap());
  }

  /**
   * @api {post} /cg/table/generate 生成代码
   * @apiVersion 1.0.0
   * @apiDescription 表信息 - 保存信息
   * @apiGroup cg/table
   *
   * @apiSuccess {string} tableName 数据库表名
   * @apiSuccess {string} data.comment 数据库表注释
   * @apiParamExample {json} 请求参数格式
   * {}
   *
   * @apiSuccess {number} code 状态码(0:成功,-1:服务异常,-2:业务提示,-3:认证超时,-4:权限不足)
   * @apiSuccess {string} errMsg 错误信息
   * @apiSuccess {bool} data 返回内容
   * @apiSuccessExample {json} 正确返回值
   * {"code":0,"errMsg":null,"data":true}
   */
  @RequestMapping(value = "/generate", method = RequestMethod.POST)
  public ApiResponse<Boolean> generate(
      @RequestParam Long projectId,
      @RequestParam Long databaseId,
      @RequestBody List<Table> tableList) {
    return tableService.generate(projectId, databaseId, tableList);
  }

}
