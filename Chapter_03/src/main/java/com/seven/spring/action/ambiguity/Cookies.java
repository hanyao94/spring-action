/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	Cake.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package com.seven.spring.action.ambiguity;

import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Component
@Cold
public class Cookies implements Dessert {
  public void eat() {
    System.out.println(".......eat Cookies!.........");
  }
}
