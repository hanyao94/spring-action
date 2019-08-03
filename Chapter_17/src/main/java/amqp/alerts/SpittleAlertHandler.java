/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	SpittleAlertHandler.java
 * 模块说明：
 * 修改历史：
 * 2019/7/25 - seven - 创建。
 */
package amqp.alerts;

import amqp.pojo.Spittle;

/**
 * @author seven
 */
public class SpittleAlertHandler {
  public void handleSpittleAlert(Spittle spittle) {
    System.out.println(spittle.getMessage());
  }
}
