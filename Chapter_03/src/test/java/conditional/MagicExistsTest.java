/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	MagicExistsTest.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package conditional;

import com.seven.spring.action.conditional.MagicConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {

  @Autowired
  private ApplicationContext context;

  /*
   * This test will fail until you set a "magic" property.
   * You can set this property as an environment variable, a JVM system property, by adding a @BeforeClass
   * method and calling System.setProperty() or one of several other options.
   */
  @Test
  public void shouldNotNull() {
    assertTrue(context.containsBean("magicBean"));
  }

}



