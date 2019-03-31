/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	spring-action
 * 文件名：	TrackCounter.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopconfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 */
@Aspect
@Component
@Profile("aroundWidthParams")
public class TrackCounter {

  private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

  @Pointcut("execution(* com.seven.spring.action.aopconfig.CompactDisc.playTrack(int)) && args(trackNumber)")
  public void trackPlayed(int trackNumber) {
  }

  @Before("trackPlayed(trackNumber)")
  public void countTrack(int trackNumber) {
    int currentCount = getPlayCount(trackNumber);
    trackCounts.put(trackNumber, currentCount + 1);
  }

  public int getPlayCount(int trackNumber) {
    return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
  }
}
