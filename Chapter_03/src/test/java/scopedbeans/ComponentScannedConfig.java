/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	ComponentScannedConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/20 - seven - 创建。
 */
package scopedbeans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author seven
 */
@Configuration
@ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION, value=Configuration.class)})
public class ComponentScannedConfig {
}
