/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	MailServiceImplTest.java
 * 模块说明：
 * 修改历史：
 * 2019/8/3 - seven - 创建。
 */
package email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_mail.config.MailConfig;
import spring_mail.email.MailService;
import spring_mail.pojo.Spitter;
import spring_mail.pojo.Spittle;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MailConfig.class)
public class MailServiceImplTest {

  @Autowired
  private MailService mailService;

  private GreenMail greenMail;//
//  //GreenMail是JavaMail的测试工具
//  @Before
//  public void greenMail() {
//    greenMail = new GreenMail(ServerSetup.SMTP);
//    greenMail.setUser("app@spitter.com", "letmein01");
//  }

  @Test
  public void sendEmail() throws Exception {
    Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "c@habuma.com", true);
    Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
    mailService.sendSimpleSpittleEmail("976445226@qq.com", spittle);
  }

  @Test
  public void sendImgEmail() throws Exception {
    Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "c@habuma.com", true);
    Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
    mailService.sendSpittleEmailWithAttachment("976445226@qq.com", spittle);
  }

  @Test
  public void sendRichTextEmail() throws Exception {
    Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "c@habuma.com", true);
    Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
    mailService.sendSpittleEmailWithRichText("976445226@qq.com", spittle);
  }

  //有點問題不可用
  @Test
  public void sendSimpleSpittleEmail() throws Exception {
    Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "c@habuma.com", true);
    Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
    mailService.sendSimpleSpittleEmail("craig@habuma.com", spittle);

    MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
    assertEquals(1, receivedMessages.length);
    MimeMessage message = receivedMessages[0];
    assertEquals("New spittle from Craig Walls", message.getSubject());
    assertEquals("Craig Walls says: Hiya!", ((String) message.getContent()).trim());
    Address[] from = message.getFrom();
    assertEquals(1, from.length);
    assertEquals("noreply@spitter.com", ((InternetAddress) from[0]).getAddress());
    assertEquals("craig@habuma.com", ((InternetAddress) message.getRecipients(MimeMessage.RecipientType.TO)[0]).getAddress());
  }
}


