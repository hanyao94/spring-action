
package com.seven.spring.action.javaconfig;

import org.springframework.stereotype.Component;

/**
 * @author seven
 */
public class SgtPeppers implements CompactDisc {
  private String title = "Sgt. Pepper's Lonely Hearts Club Band";
  private String artist = "The Beatles";

  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }
}
