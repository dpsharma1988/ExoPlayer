package com.google.android.exoplayer2.vocab;

/**
 * Created by Hisham on 04/Oct/2018 - 17:51
 */
public class CredUpdateSingleton {

  private CredUpdateSingleton() {
  }

  private static final CredUpdateSingleton ourInstance = new CredUpdateSingleton();

  private String token;
  private String videoId;
  private String licecnceUrl;

  public static CredUpdateSingleton getInstance() {
    return ourInstance;
  }


  public String getToken() {
    return token;
  }

  public CredUpdateSingleton setToken(String token) {
    this.token = token;
    return this;
  }

  public String getVideoIdAndResetIt() {
    String temp = videoId;
    videoId = null;
    return temp;
  }

  public CredUpdateSingleton setVideoId(String videoId) {
    this.videoId = videoId;
    return this;
  }

  public String getLicecnceUrl() {
    return licecnceUrl;
  }

  public CredUpdateSingleton setLicecnceUrl(String licecnceUrl) {
    this.licecnceUrl = licecnceUrl;
    return this;
  }
}
