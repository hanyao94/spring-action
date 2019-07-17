/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	SecuredSpittleService.java
 * 模块说明：
 * 修改历史：
 * 2019/7/10 - seven - 创建。
 */
package service;

import org.springframework.security.access.annotation.Secured;
import pojo.Spittle;

/**
 * @author seven
 */
public class SecuredSpittleService implements SpittleService {

  @Secured({"ROLE_SPITTER", "ROLE_ADMIN"})
  public void addSpittle(Spittle spittle) {
    System.out.println("Method was called successfully");
  }

}
