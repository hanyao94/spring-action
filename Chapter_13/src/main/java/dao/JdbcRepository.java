/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
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

  T save(T pojo) throws Exception;

  T findOne(long id);

  T findByName(String Name);

  List<T> findAll();
}
