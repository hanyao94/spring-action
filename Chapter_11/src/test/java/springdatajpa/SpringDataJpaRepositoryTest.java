/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	SpringDataJpaRepositoryTest.java
 * 模块说明：
 * 修改历史：
 * 2019/6/24 - seven - 创建。
 */
package springdatajpa;

import com.spring.action.redis.springdatajpa.config.SpringDataJpaConfig;
import com.spring.action.redis.springdatajpa.dao.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJpaConfig.class)
public class SpringDataJpaRepositoryTest {

  @Autowired
  private RoleRepository roleRepository;

  @Test
  public void count() {
    assertEquals(2, roleRepository.count());
  }

  @Test
  public void findName(){
    assertEquals("user2", roleRepository.findByName("user2").getName());
  }

  @Test
  public void findAllAdRoles(){
    assertEquals(1, roleRepository.findAllAdRoles().size());
  }

  @Test
  public void eliteSweep(){
    assertEquals(1, roleRepository.eliteSweep());
  }

}
