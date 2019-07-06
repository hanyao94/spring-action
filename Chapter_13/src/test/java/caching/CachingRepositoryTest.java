/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	JdbcRepositoryTest.java
 * 模块说明：
 * 修改历史：
 * 2019/5/12 - seven - 创建。
 */
package caching;

import config.RootConfig;
import dao.JdbcRepository;
import dao.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Role;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CachingRepositoryTest {

  @Autowired
  private RoleRepository roleRepository;

  @Test
  public void count() {
    assertEquals(1, roleRepository.count());
  }

  @Test
  public void save() throws Exception {
    Role role = new Role();
    role.setName("test");
    role.setIsUsing(1);
    roleRepository.save(role);
  }

  @Test
  public void update() throws Exception {
    Role role = roleRepository.findOne(15);
    role.setName("user1");
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

  @Test
  public void testCache() throws InterruptedException {
    Role role = roleRepository.findOne(15);
    System.out.println("第一次取");
    Thread.sleep(2000);
    System.out.println("第二次取" + roleRepository.findOne(15));
    Thread.sleep(2000);
    System.out.println("第三次取" + roleRepository.findOne(15));
  }

}
