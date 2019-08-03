/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	MailConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/8/3 - seven - 创建。
 */
package spring_mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author seven
 */
@Configuration
@ComponentScan("spring_mail.email")
@PropertySource("classpath:mail.properties")
public class MailConfig {

  @Bean
  //JavaMailSenderImpl实现JavaMailSender，JavaMailSender继承MailSender
  public JavaMailSender mailSender(Environment env) {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(env.getProperty("mailserver.host"));//host默认是底层JavaMail会话的主机
    mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));//port默认是标准的SMTP端口25
    mailSender.setUsername(env.getProperty("mailserver.username"));
    mailSender.setPassword(env.getProperty("mailserver.password"));
    return mailSender;
  }
}
