package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 15:18
 */
public abstract class KeyHelper implements Serializable, ILicenceTo {

    private String m3u8Path;
    private String token;
    private String licenceUrl;
    private String localEncryptionKey;
    private String localEncryptionIV;
    private ILicenceContract licenceContract;

    protected KeyHelper(String m3u8Path, String token, String licenceUrl, String localEncryptionKey, String localEncryptionIV) {
        this.m3u8Path = m3u8Path;
        this.token = token;
        this.licenceUrl = licenceUrl;
        this.localEncryptionKey = localEncryptionKey;
        this.localEncryptionIV = localEncryptionIV;
    }

    /*package*/ void setLicence(ILicenceContract licence) {
        this.licenceContract = licence;
    }

    @Override
    public ILicenceContract getLicence() {
        return this.licenceContract;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getLicenceUrl() {
        return licenceUrl;
    }

    public String getM3U8Path() {
        return m3u8Path;
    }

    @Override
    public String getLocalEncryptionIV() {
        return localEncryptionIV;
    }

    @Override
    public String getLocalEncryptionKey() {
        return localEncryptionKey;
    }
}
