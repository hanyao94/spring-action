/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	RoleRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/6/23 - seven - 创建。
 */
package com.spring.action.redis.springdatajpa.dao;

import com.spring.action.redis.springdatajpa.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author seven
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
  int eliteSweep();

  Role findByName(String name);

  List<Role> findByNameLike(String name);

  @Query("select s from Role s where s.name like '%Ad'")
  List<Role> findAllAdRoles();
}
