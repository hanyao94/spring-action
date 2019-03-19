/**
 * <p>
 * 项目名：	spring-action
 * 文件名：	CDPlayerTest.java
 * 模块说明：
 * 修改历史：
 * 2019/3/19 - seven - 创建。
 */
package com.seven.spring.action.javaconfig;

import com.seven.spring.action.autoconfig.CDPlayerConfig;
import com.seven.spring.action.autoconfig.CompactDisc;
import com.seven.spring.action.autoconfig.MediaPlay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author seven
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

  @Autowired
  private MediaPlay player;

  @Autowired
  private CompactDisc cd;

  @Test
  public void cdShouldNotBeNull() {
    assertNotNull(cd);
  }


  @Test
  public void play(){
    player.play();
  }
}
