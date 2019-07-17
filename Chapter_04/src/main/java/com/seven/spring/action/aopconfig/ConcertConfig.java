/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	ConcertConfig.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author seven
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {

  @Bean
  public CompactDisc sgtPeppers() {

    List<String> tracks = new ArrayList<String>();
    tracks.add("sge. aaaaaaaa");
    tracks.add("sge. bbbbbbbbb");
    tracks.add("sge. cccccccccc");
    tracks.add("sge. ddddddddddd");
    tracks.add("sge. eeeeeeeeeeee");
    tracks.add("sge. fffffffffffff");
    tracks.add("sge. hhhhhhhhhhhhhh");
    tracks.add("sge. iiiiiiiiiiiiiii");

    BlankDisc cd = new BlankDisc("sge title", "the beateles", tracks);
    return cd;
  }
}
