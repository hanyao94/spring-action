/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	CDPlayerConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/19 - seven - 创建。
 */
package com.seven.spring.action.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author seven
 */

@Configuration
public class CDPlayerConfig {

  @Bean
  public CompactDisc sgtPeppers() {
    return new SgtPeppers();
  }

  @Bean
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }

}
