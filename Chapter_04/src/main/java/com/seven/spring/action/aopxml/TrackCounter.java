/**
 *
 * <p>
 * 项目名：	spring-action
 * 文件名：	TrackCounter.java
 * 模块说明：
 * 修改历史：
 * 2019/3/26 - seven - 创建。
 */
package com.seven.spring.action.aopxml;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 */

public class TrackCounter {

  private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

  public void trackPlayed(int trackNumber) {
  }

  public void countTrack(int trackNumber) {
    int currentCount = getPlayCount(trackNumber);
    trackCounts.put(trackNumber, currentCount + 1);
  }

  public int getPlayCount(int trackNumber) {
    return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
  }
}
