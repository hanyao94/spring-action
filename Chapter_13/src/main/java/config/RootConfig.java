/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	RootConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/7/6 - seven - 创建。
 */
package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author seven
 */
@Configuration
@Import({CacheConfig.class, JdbcConfig.class})
public class RootConfig {
}
