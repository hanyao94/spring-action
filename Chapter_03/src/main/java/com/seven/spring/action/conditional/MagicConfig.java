/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
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

/**
 * @author seven
 */
@Configuration
public class MagicConfig {

  @Bean
  @Conditional(MagicExistCondition.class)
  public MagicBean magicBean(){
    return  new MagicBean();
  }
}
