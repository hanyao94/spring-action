/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	SpitterMailServiceImpl.java
 * 模块说明：
 * 修改历史：
 * 2019/8/3 - seven - 创建。
 */
package spring_mail.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import spring_mail.pojo.Spittle;

/**
 * @author seven
 */
@Component
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender mailSender;

  public void sendSimpleSpittleEmail(String to, Spittle spittle) {
    SimpleMailMessage message = new SimpleMailMessage();
    String name = spittle.getSpitter().getFullName();
    message.setFrom("1345564313@qq.com");
    message.setTo(to);
    message.setSubject("New Hello from " + name);
    message.setText(name + " says: " + spittle.getText());
    mailSender.send(message);

  }

  public void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    String name = spittle.getSpitter().getFullName();
    helper.setFrom("1345564313@qq.com");
    helper.setTo(to);
    helper.setSubject("New Hello from " + name);
    helper.setText(name + " says: " + spittle.getText());
    ClassPathResource couponImage = new ClassPathResource("/collateral/coupon.jpg");
    helper.addAttachment("Coupon.png", couponImage);
    mailSender.send(message);
  }

  public void sendSpittleEmailWithRichText(String to, Spittle spittle) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    String name = spittle.getSpitter().getFullName();
    helper.setFrom("1345564313@qq.com");
    helper.setTo(to);
    helper.setSubject("New Hello from " + name);
    //富文本，HTML
    helper.setText("<html><body><img src='cid:spitterLogo'>" +
                           "<h4>" + spittle.getSpitter().getFullName() + " says...</h4>" +
                           "<i>" + spittle.getText() + "</i>" +
                           "</body></html>", true);
    ClassPathResource couponImage = new ClassPathResource("/collateral/coupon.jpg");
    //内联图片
    helper.addInline("spitterLogo", couponImage);
    mailSender.send(message);
  }
}
