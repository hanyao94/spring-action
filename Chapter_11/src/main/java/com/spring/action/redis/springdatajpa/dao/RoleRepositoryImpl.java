/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	RoleRepositoryImpl.java
 * 模块说明：
 * 修改历史：
 * 2019/6/23 - seven - 创建。
 */
package com.spring.action.redis.springdatajpa.dao;

import com.spring.action.redis.springdatajpa.pojo.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author seven
 */
public class RoleRepositoryImpl {

  @PersistenceContext(unitName = "spring-action-springDataJpa.persistent-unit")
  private EntityManager em;

  @Transactional
  public int eliteSweep() {
    String update =
            "UPDATE " + Role.class.getName() + " role " +
                    "SET role.name = 'Elite' " +
                    "WHERE role.isUsing = 1 ";
    return em.createQuery(update).executeUpdate();
  }
}
