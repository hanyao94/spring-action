/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	JpaRepositoryTest.java
 * 模块说明：
 * 修改历史：
 * 2019/6/18 - seven - 创建。
 */
package jpa;

import com.spring.action.redis.jpa.config.JpaConfig;
import com.spring.action.redis.jpa.dao.JpaRepository;
import com.spring.action.redis.jpa.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class JpaRepositoryTest {

  @Autowired
  private JpaRepository<Role> roleRepository;

  @Test
  public void count() {
    assertEquals(1, roleRepository.count());
  }

  @Test
  public void save() {
    Role role = new Role();
    role.setName("user");
    role.setIsUsing(1);
    roleRepository.save(role);
  }

  @Test
  public void update() {
    Role role = roleRepository.findOne(6);
    role.setName("user2");
    role.setIsUsing(1);
    roleRepository.save(role);
  }

  @Test
  public void finaAByName() {
    Role role = roleRepository.findByName("user");
    assertEquals(role.getName(), "user");
  }

  @Test
  public void finaAll() {
    List<Role> roles = roleRepository.findAll();
    for (Role role : roles) {
      System.out.println(role.getName());
    }
  }

}
