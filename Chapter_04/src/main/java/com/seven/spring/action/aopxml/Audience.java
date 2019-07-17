/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	Audience.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopxml;

/**
 * @author seven
 */

public class Audience {

  public void performance(){
  }

  public void silenceCellPhones() {
    System.out.println("Silencing cell phones");
  }

  public void takeSeats() {
    System.out.println("Taking seats");
  }

  public void applause() {
    System.out.println("CLAP CLAP CLAP!!!");
  }

  public void demandRefund() {
    System.out.println("Demanding a refund");
  }

  //@After() //通知方法会在目标方法返回或抛出异常后调用
}
