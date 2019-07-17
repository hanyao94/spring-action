/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	MagicExistCodition.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package com.seven.spring.action.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author seven
 */
public class MagicExistCondition implements Condition {
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
    Environment env = context.getEnvironment();
    return env.containsProperty("magic");
  }
}
