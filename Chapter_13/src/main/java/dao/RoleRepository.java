/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	RoleRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/7/6 - seven - 创建。
 */
package dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import pojo.Role;

import java.util.List;

/**
 * @author seven
 */
public interface RoleRepository extends JdbcRepository<Role>{

  long count();

  @CachePut(value = "serviceCache", key = "#result.id")
  Role save(Role pojo) throws Exception;

  @Cacheable(value = "serviceCache")
  Role findOne(long id);

  @Cacheable(value = "serviceCache")
  Role findByName(String Name);

  @Cacheable(value = "serviceCache")
  List<Role> findAll();

  @CacheEvict(value="serviceCache",condition="")
  void delete(long id);
}
