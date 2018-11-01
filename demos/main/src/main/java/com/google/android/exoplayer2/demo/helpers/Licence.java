package com.google.android.exoplayer2.demo.helpers;

import com.vocabimate.protocol.ILicenceContract;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hisham on 29/Oct/2018 - 21:08
 */
public class Licence implements ILicenceContract, Serializable {

    private int userId;
    private int videoId;
    private String decryptionKey;
    private Date validateDt;
    private Date createDt;
    private String createUserId;
    private Date updateDt;
    private String updateUserId;
    private String delInd;
    private long expTime;//long videoOfflineExpiryTime();
    private long serverTime;//    long serverTime();
    private VideoSubscription videoSubscription;
    private int gracePeriod; //long gracePeriodInMillis();
    private long videoProviderExpiryTime;//long videoProviderExpiryTime();


    public int getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getValidateDt() {
        return validateDt;
    }

    public void setValidateDt(Date validateDt) {
        this.validateDt = validateDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getDelInd() {
        return delInd;
    }

    public void setDelInd(String delInd) {
        this.delInd = delInd;
    }

    public String getDecryptionKey() {
        return decryptionKey;
    }

    public long getVideoProviderExpiryTime() {
        return videoProviderExpiryTime;
    }

    public void setVideoProviderExpiryTime(long videoProviderExpiryTime) {
        this.videoProviderExpiryTime = videoProviderExpiryTime;
    }

    public void setDecryptionKey(String decryptionKey) {
        this.decryptionKey = decryptionKey;
    }

    public long getExpTime() {
        return expTime;
    }

    public void setExpTime(long expTime) {
        this.expTime = expTime;
    }



    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public long getServerTime() {
        return serverTime;
    }

    public VideoSubscription getVideoSubscription() {
        return videoSubscription;
    }

    public void setVideoSubscription(VideoSubscription videoSubscription) {
        this.videoSubscription = videoSubscription;
    }

    @Override
    public String toString() {
        return "LicenseFile [userId=" + userId + ", videoId=" + videoId + ", decryptionKey=" + decryptionKey
                + ", validateDt=" + validateDt + ", createDt=" + createDt + ", createUserId=" + createUserId
                + ", updateDt=" + updateDt + ", updateUserId=" + updateUserId + ", delInd=" + delInd + ", expTime="
                + expTime + ", serverTime=" + serverTime + ", videoSubscription=" + videoSubscription + "]";
    }



}
