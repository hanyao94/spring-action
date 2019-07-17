/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	UserController.java
 * 模块说明：
 * 修改历史：
 * 2019/4/16 - seven - 创建。
 */
package com.seven.spring.action.web;

import com.seven.spring.action.api.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seven
 */
@RestController
public class UserController implements UserService {

  @Override
  public String get(@PathVariable("tenantId") String tenantId, @PathVariable("id")String id, @RequestParam(value = "parts", required = false) String parts) {
    return tenantId + id + parts;
  }
}
