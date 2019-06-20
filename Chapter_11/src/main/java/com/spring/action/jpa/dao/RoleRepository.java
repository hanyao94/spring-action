/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	RoleRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/6/18 - seven - 创建。
 */
package com.spring.action.jpa.dao;

import com.spring.action.jpa.pojo.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author seven
 */
@Repository
public class RoleRepository implements JpaRepository<Role> {

  @PersistenceContext(unitName = "spring-action-jpa.persistent-unit")
  private EntityManager em;

  public long count() {
    return findAll().size();
  }

  @Transactional
  public Role save(Role pojo) {
    if (pojo.getId() == null) {
      em.persist(pojo);
    } else {
      em.merge(pojo);
    }

    return pojo;
  }

  public Role findOne(Integer id) {
    return em.find(Role.class, id);
  }

  public Role findByName(String name) {
    return (Role) em.createQuery("from " + Role.class.getName() + " where name = :name").setParameter("name", name).getSingleResult();
  }

  public List<Role> findAll() {
    return em.createQuery("from " + Role.class.getName()).getResultList();
  }
}
