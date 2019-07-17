/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	RoleRepository.java
 * 模块说明：
 * 修改历史：
 * 2019/5/12 - seven - 创建。
 */
package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pojo.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author seven
 */
@Repository
public class RoleRepository implements JdbcRepository<Role> {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public long count() {
    return jdbcTemplate.queryForObject("select count(*) from tb_role", Long.class);
  }

  @Transactional
  public Role save(Role pojo) {
    Integer id = pojo.getId();
    if (id == null) {
      long returnId = insertAndReturnId(pojo);
      pojo.setId(id);
      return pojo;
    } else {
      jdbcTemplate.update("update tb_role set name=?,is_using=?,flag=? where  id= ?",
                          pojo.getName(),
                          pojo.getIsUsing(),
                          pojo.getFlag(),
                          id);
    }

    return pojo;
  }

  private long insertAndReturnId(Role role) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("tb_role");
    jdbcInsert.setGeneratedKeyName("id");
    Map<String, Object> args = new HashMap<String, Object>();
    args.put("name", role.getName());
    args.put("is_using", role.getIsUsing());
    args.put("flag", role.getFlag());
    long id = jdbcInsert.executeAndReturnKey(args).longValue();
    return id;
  }

  public Role findOne(long id) {
    return jdbcTemplate.queryForObject("select id, name, is_using,flag from tb_role where id = ?", new RoleRowMapper(), id);
  }

  public Role findByName(String name) {
    return jdbcTemplate.queryForObject("select id, name, is_using,flag from tb_role where name = ?", new RoleRowMapper(), name);
  }

  public List<Role> findAll() {
    return jdbcTemplate.query("select id, name, is_using from tb_role", new RoleRowMapper());
  }

  private static final class RoleRowMapper implements RowMapper<Role> {

    public Role mapRow(ResultSet rs, int i) throws SQLException {
      Role target = new Role();
      target.setId(rs.getInt("id"));
      target.setName(rs.getString("name"));
      target.setIsUsing(rs.getInt("is_using"));
      return target;
    }
  }
}
