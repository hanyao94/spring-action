/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	SpitterMailService.java
 * 模块说明：
 * 修改历史：
 * 2019/8/3 - seven - 创建。
 */
package spring_mail.email;

import javax.mail.MessagingException;
import spring_mail.pojo.Spittle;

/**
 * @author seven
 */
public interface MailService {
  void sendSimpleSpittleEmail(String to, Spittle spittle);

  void sendSpittleEmailWithAttachment(String to, Spittle spittle)
          throws MessagingException;

  void sendSpittleEmailWithRichText(String to, Spittle spittle) throws MessagingException;
}
