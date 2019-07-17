/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	UserServer.java
 * 模块说明：
 * 修改历史：
 * 2019/4/16 - seven - 创建。
 */
package com.seven.spring.action.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author seven
 */
@Api(tags = "用户接口")
@RequestMapping(value = "/v1/{tenantId}/userservice", produces = "application/json;charset=utf-8")
public interface UserService {

  @ApiOperation(value = "根据id取得用户")
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  String get(@ApiParam(value = "租户ID", required = true) @PathVariable(value = "tenantId", required = true) String tenantId,
             @ApiParam(value = "id", required = true) @PathVariable(value = "id", required = true) String id,
             @ApiParam(value = "parts", required = false) @RequestParam(value = "parts", required = false) String parts);

}
