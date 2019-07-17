/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	MagicConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package com.seven.spring.action.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author seven
 */
@Configuration
//@PropertySource("classpath:META-INF/conditional/app.properties") //设置之后会出现环境变量
public class MagicConfig {

  @Bean
  @Conditional(MagicExistCondition.class)
  public MagicBean magicBean(){
    return  new MagicBean();
  }
}
