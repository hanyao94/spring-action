/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	Audience.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Aspect
@Component
@Profile("simple")
public class Audience {

  @Pointcut("execution(* com.seven.spring.action.aopconfig.Performance.perform(..))")
  public void performance(){
  }

  @Before("performance()")//通知方法会在目标方法调用之前执行
  public void silenceCellPhones() {
    System.out.println("Silencing cell phones");
  }

  @Before("performance()")//通知方法会在目标方法调用之前执行
  public void takeSeats() {
    System.out.println("Taking seats");
  }

  @AfterReturning("performance()")//通知方法会在目标方法返回后调用
  public void applause() {
    System.out.println("CLAP CLAP CLAP!!!");
  }

  @AfterThrowing("performance()")//通知方法会在目标方法抛出异常后调用
  public void demandRefund() {
    System.out.println("Demanding a refund");
  }

  //@After() //通知方法会在目标方法返回或抛出异常后调用
}
