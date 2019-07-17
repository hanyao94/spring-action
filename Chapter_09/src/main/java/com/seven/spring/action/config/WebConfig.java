/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	WebConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/4/3 - seven - 创建。
 */
package com.seven.spring.action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

/**
 * @author seven
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.seven.spring.action.web")
@EnableSwagger2
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposeContextBeansAsAttributes(true);
    return resolver;
  }

  //配置静态资源处理
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  /**
   * 创建API应用
   * apiInfo() 增加API相关信息
   * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
   * 本例采用指定扫描的包路径来定义指定要建立API的目录。
   *
   * @return
   */
  @Bean
  public Docket swaggerDocket() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).build();
  }

  /**
   * 创建该API的基本信息（这些基本信息会展现在文档页面中）
   * 访问地址：http://项目实际地址/swagger-ui.html
   *
   * @return
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("seven test API文档")
            .description("接口文档")
            .termsOfServiceUrl("http://sanchips.github.io")
            .version("1.0.0").build();
  }
}
