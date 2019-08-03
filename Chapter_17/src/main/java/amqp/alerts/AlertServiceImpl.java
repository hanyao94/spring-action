/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	AlertServiceImpl.java
 * 模块说明：
 * 修改历史：
 * 2019/7/25 - seven - 创建。
 */
package amqp.alerts;

import amqp.pojo.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author seven
 */
@Service
public class AlertServiceImpl implements AlertService {

  private RabbitTemplate rabbit;

  @Autowired
  public AlertServiceImpl(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }

  public void sendSpittleAlert(Spittle spittle) {
    rabbit.convertAndSend("spittle.alert.exchange",
                          "spittle.alerts",
                          spittle);
  }
}
