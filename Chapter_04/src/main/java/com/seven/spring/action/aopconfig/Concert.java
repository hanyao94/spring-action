/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	Concert.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Component
public class Concert implements Performance {
  public void perform() {
    System.out.println("perform...");
  }
}
