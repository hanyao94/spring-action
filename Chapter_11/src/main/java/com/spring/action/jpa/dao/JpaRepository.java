/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	JpaRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/6/18 - seven - 创建。
 */
package com.spring.action.jpa.dao;

import java.util.List;

/**
 * @author seven
 */
public interface JpaRepository<T> {
  long count();

  T save(T pojo);

  T findOne(Integer id);

  T findByName(String name);

  List<T> findAll();
}
