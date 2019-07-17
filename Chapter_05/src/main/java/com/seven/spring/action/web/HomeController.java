/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	HomeController.java
 * 模块说明：
 * 修改历史：
 * 2019/4/3 - seven - 创建。
 */
package com.seven.spring.action.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author seven
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping(method = RequestMethod.GET)
  public String home(Model model) {
    return "home";
  }
}
