package com.seven.spring.action.aopconfig;

import org.springframework.context.annotation.Profile;

import java.util.List;


@Profile("aroundWidthParams")
public class BlankDisc implements CompactDisc {

  private String title;
  private String artist;
  private List<String> tracks;

  public BlankDisc(String title, String artist, List<String> tracks) {
    this.title = title;
    this.artist = artist;
    this.tracks = tracks;
  }

  public void play() {
    System.out.println("Playing " + title + " by " + artist);
    for (String track : tracks) {
      System.out.println("-Track: " + track);
    }
  }

  public void playTrack(int number) {
    System.out.println("-Track: " + tracks.get(number));
  }

}
