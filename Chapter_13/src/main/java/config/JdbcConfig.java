package config; /**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	config.JdbcConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/5/11 - seven - 创建。
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author seven
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"dao"})
public class JdbcConfig {

//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource ds = new DriverManagerDataSource();
//    ds.setDriverClassName("com.mysql.jdbc.Driver");
//    ds.setUrl("jdbc:mysql://localhost:3306/springAction");
//    ds.setUsername("root");
//    ds.setPassword("root");
//    return ds;
//  }

  // dhcp线程池
  @Bean
  public BasicDataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/springAction");
    ds.setUsername("root");
    ds.setPassword("root");
    ds.setInitialSize(5);
    ds.setMaxActive(10);
    return ds;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

//
//  @Bean
//  public JdbcRepository jdbcRepository() {
//    return new RoleRepository();
//  }
}
