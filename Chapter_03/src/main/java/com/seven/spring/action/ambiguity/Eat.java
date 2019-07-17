/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	Eat.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package com.seven.spring.action.ambiguity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Component
public class Eat {
  private Dessert dessert;

  public Dessert getDessert() {
    return dessert;
  }

  @Autowired
  //@Qualifier("iceCream") //使用限定符，参数就是想要注入的bean的ID,所有使用@Component注解声明的类都会创建为bean，并且bean的ID为首字母变为小写的类名
  //@Qualifier("cold") // 实现类以及注入的地方使用相同的名称
  @Cold//自定义的限定符注解
  public void setDessert(Dessert dessert) {
    this.dessert = dessert;
  }

  public void eat() {
    dessert.eat();
  }
}
