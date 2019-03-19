/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	CDPlayerConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/19 - seven - 创建。
 */
package com.seven.spring.action.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author seven
 */

@Configuration
@ComponentScan
//@ComponentScan(basePackages = {"com.seven.spring.action.autoconfig"}) //扫描基础包，设置后，对应包下的类，无需再加@Component注解
public class CDPlayerConfig {

}
