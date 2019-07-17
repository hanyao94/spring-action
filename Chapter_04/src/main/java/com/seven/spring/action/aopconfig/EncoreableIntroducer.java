/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	EncoreableIntroducer.java
 * 模块说明：
 * 修改历史：
 * 2019/3/31 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author seven
 * 利用切面来动态为接口加入方法
 */
@Aspect
@Component
@Profile("introduce")
public class EncoreableIntroducer {
  @DeclareParents(value = "com.seven.spring.action.aopconfig.Performance+", defaultImpl = DefaultEncoreable.class)
  public static Encoreable encoreable;
}
