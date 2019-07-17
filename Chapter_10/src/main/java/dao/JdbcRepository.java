/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	JdbcRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/5/12 - seven - 创建。
 */
package dao;

import java.util.List;

/**
 * @author seven
 */
public interface JdbcRepository<T> {

  long count();

  T save(T pojo);

  T findOne(long id);

  T findByName(String Name);

  List<T> findAll();
}
