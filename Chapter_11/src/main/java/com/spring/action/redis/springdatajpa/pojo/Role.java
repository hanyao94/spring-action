package com.spring.action.redis.springdatajpa.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_role")
@Entity
public class Role {

  private Integer id;

  private String name;

  private Integer isUsing;

  private String flag;

  private String createTime;

  private String updateTime;

  private String createUser;

  private String updateUser;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  @Column(name = "is_using")
  public Integer getIsUsing() {
    return isUsing;
  }

  public void setIsUsing(Integer isUsing) {
    this.isUsing = isUsing;
  }

  @Column(name = "flag")
  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag == null ? null : flag.trim();
  }

  @Column(name = "create_time")
  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime == null ? null : createTime.trim();
  }

  @Column(name = "update_time")
  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime == null ? null : updateTime.trim();
  }

  @Column(name = "create_user")
  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser == null ? null : createUser.trim();
  }

  @Column(name = "update_user")
  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser == null ? null : updateUser.trim();
  }
}