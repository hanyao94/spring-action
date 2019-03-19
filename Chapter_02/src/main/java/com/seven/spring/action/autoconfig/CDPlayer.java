/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	CDPlayer.java
 * 模块说明：
 * 修改历史：
 * 2019/3/19 - seven - 创建。
 */
package com.seven.spring.action.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author seven
 */
@Component
public class CDPlayer implements MediaPlay {

  private CompactDisc cd;

  @Autowired
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }
}
