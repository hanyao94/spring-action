package com.seven.spring.action.xmlconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/xmlconfig/PNamespaceWithUtilNamespaceTest-context.xml" })
public class PNamespaceWithUtilNamespaceTest {


  @Autowired
  private MediaPlayer player;

  @Test
  public void play() {
    player.play();
  }

}
