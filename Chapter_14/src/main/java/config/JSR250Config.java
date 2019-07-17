package config; /**
 * 
 * <p>
 * 项目名：	spring-action
 * 文件名：	config.JSR250Config.java
 * 模块说明：
 * 修改历史：
 * 2019/7/10 - seven - 创建。
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import service.JSR250SpittleService;
import service.SpittleService;

/**
 * @author seven
 */
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class JSR250Config extends GlobalMethodSecurityConfiguration {
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
  }

  @Bean
  public SpittleService spitterService() {
    return new JSR250SpittleService();
  }
}
