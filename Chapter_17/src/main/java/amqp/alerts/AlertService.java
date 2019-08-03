/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	AlertService.java
 * 模块说明：
 * 修改历史：
 * 2019/7/25 - seven - 创建。
 */
package amqp.alerts;

import amqp.pojo.Spittle;

/**
 * @author seven
 */
public interface AlertService {
  void sendSpittleAlert(Spittle spittle);
}
