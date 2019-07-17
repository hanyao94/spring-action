/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	JdbcRepositoryTest.java
 * 模块说明：
 * 修改历史：
 * 2019/5/12 - seven - 创建。
 */
package jdbc;

import config.JdbcConfig;
import dao.JdbcRepository;
import dao.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pojo.Role;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcRepositoryTest {

  @Autowired
  private JdbcRepository<Role> roleRepository;

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
    Role role = roleRepository.findOne(5);
    role.setName("admin");
    role.setIsUsing(1);
    roleRepository.save(role);
  }

  @Test
  public void finaAByName() {
    Role role = roleRepository.findByName("admin");
    assertEquals(role.getName(),"admin");
  }

  @Test
  public void finaAll() {
    List<Role> roles = roleRepository.findAll();
    for (Role role: roles) {
      System.out.println(role.getName());
    }
  }
}
