package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 10/Oct/2018 - 17:29
 */
public class KeyHelperModel implements Serializable {

  private String m3u8Path;
  private String token;
  private String videoId;
  private String licecnceUrl;
  private String keyPath;

  public KeyHelperModel(){

  }

  public String getM3u8Path() {
    return m3u8Path;
  }

  public KeyHelperModel setM3u8Path(String m3u8Path) {
    this.m3u8Path = m3u8Path;
    return this;
  }

  public String getToken() {
    return token;
  }

  public KeyHelperModel setToken(String token) {
    this.token = token;
    return this;
  }

  public String getVideoId() {
    return videoId;
  }

  public KeyHelperModel setVideoId(String videoId) {
    this.videoId = videoId;
    return this;
  }

  public String getLicecnceUrl() {
    return licecnceUrl;
  }

  public KeyHelperModel setLicecnceUrl(String licecnceUrl) {
    this.licecnceUrl = licecnceUrl;
    return this;
  }

  public String getKeyPath() {
    return keyPath;
  }

  public KeyHelperModel setKeyPath(String keyPath) {
    this.keyPath = keyPath;
    return this;
  }
}
