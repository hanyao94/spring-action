/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	CacheConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/7/6 - seven - 创建。
 */
package config;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author seven
 */
@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public EhCacheCacheManager cacheManager(CacheManager cm) {
    return new EhCacheCacheManager(cm);
  }

  @Bean
  public EhCacheManagerFactoryBean ehcache() {
    EhCacheManagerFactoryBean ehCacheFactoryBean =
            new EhCacheManagerFactoryBean();
    ehCacheFactoryBean.setConfigLocation(
            new ClassPathResource("cache/ehcache.xml"));
    return ehCacheFactoryBean;
  }

}
