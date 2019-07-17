/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	RootConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/4/3 - seven - 创建。
 */
package com.seven.spring.action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置文件。
 * [Springfox官方集成文档](http://springfox.github.io/springfox/docs/current/)
 * [Swagger注解官方文档](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)
 * <p>
 * 配置注意事项：
 * 1. swagger及swagger-ui的添加，注意版本
 * 2. 该config文件的注解添加，@Configuration与@EnableSwagger2为必须添加
 * 3. 配置servlet-mapping为"/"，因为会生成静态文件，因此需要注意路径穿透
 *
 * @author seven
 */
@Configuration
@ComponentScan(basePackages = {"com.seven.spring.action"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
