package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 15:18
 */
public abstract class KeyHelper implements Serializable, ILicenceTo{

    private String m3u8Path;
    private String token;
    private String licenceUrl;

    public KeyHelper(String m3u8Path, String token, String licenceUrl) {
        this.m3u8Path = m3u8Path;
        this.token = token;
        this.licenceUrl = licenceUrl;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getLicenceUrl() {
        return licenceUrl;
    }

    @Override
    public String getM3U8Path() {
        return m3u8Path;
    }
}
