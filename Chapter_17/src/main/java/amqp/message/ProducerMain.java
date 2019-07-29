/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	Producer.java
 * 模块说明：
 * 修改历史：
 * 2019/7/26 - seven - 创建。
 */
package amqp.message;

import amqp.alerts.AlertService;
import amqp.alerts.AlertServiceImpl;
import amqp.pojo.Spittle;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author seven
 */
public class ProducerMain {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/amqp-producer.xml");
    RabbitTemplate template = (RabbitTemplate) context.getBean("rabbitTemplate");
    for (int i = 0; i < 20; i++) {
      System.out.println("Sending message #" + i);
      Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
      template.convertAndSend("spittle.alert.exchange", "spittle.alerts", spittle);
      Thread.sleep(5000);
    }

    System.out.println("Done!");
  }
}
