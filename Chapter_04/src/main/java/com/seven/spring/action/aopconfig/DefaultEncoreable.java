/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	DefaultEncoreable.java
 * 模块说明：
 * 修改历史：
 * 2019/3/31 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Component
@Profile("introduce")
public class DefaultEncoreable implements Encoreable{
  public void performEncore() {
    System.out.println("performEncore...");
  }
}
