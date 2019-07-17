/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	AudienceAround.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Aspect
@Component
@Profile("around")
public class AudienceAround {

  @Pointcut("execution(* com.seven.spring.action.aopconfig.Performance.perform(..)))")
  public void performance() {

  }

  @Around("performance()")
  public void watchPerformance(ProceedingJoinPoint jp) {
    try {
      System.out.println("Silencing cell phones");
      System.out.println("Taking seats");
      jp.proceed(); //调用被通知的方法，可对它进行多次调用
      System.out.println("CLAP CLAP CLAP!!!");
    } catch (Throwable e) {
      System.out.println("Demanding a refund");
    }
  }
}
