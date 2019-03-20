/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	MagicExistsTest.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package ambiguity;

import com.seven.spring.action.ambiguity.AmbugeConfig;
import com.seven.spring.action.ambiguity.Eat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author seven
 */

public class AmbiguityTest {

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes = AmbugeConfig.class)
  public static class AmbiguityAutoConfigTest {
    @Autowired
    private Eat eat;

    @Test
    public void eat() {
      eat.eat();
    }
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(locations = {"classpath:META-INF/ambiguity/ambuge-config.xml"})
  public static class AmbiguityXmlConfigTest {
    @Autowired
    private Eat eat;

    @Test
    public void eat() {
      eat.eat();
    }
  }

}



