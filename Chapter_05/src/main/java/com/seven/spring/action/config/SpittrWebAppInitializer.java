/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	SpittrWebAppInitializer.java
 * 模块说明：
 * 修改历史：
 * 2019/4/3 - seven - 创建。
 */
package com.seven.spring.action.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author seven
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class};
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfig.class};
  }

  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
