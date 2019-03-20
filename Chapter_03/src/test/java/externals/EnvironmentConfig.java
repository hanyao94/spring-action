/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	EnvironmentConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package externals;

import com.seven.spring.action.externals.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author seven
 */
@Configuration
@PropertySource("classpath:META-INF/externals/app.properties")
public class EnvironmentConfig {

  @Autowired
  Environment env;

  @Bean
  public BlankDisc blankDisc() {
    return new BlankDisc(
            env.getProperty("disc.title"),
            env.getProperty("disc.artist"));
  }
}
