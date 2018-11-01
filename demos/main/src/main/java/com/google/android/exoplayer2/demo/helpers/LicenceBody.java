package com.google.android.exoplayer2.demo.helpers;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vocabimate.protocol.ILicenceWrapperContract;
import com.vocabimate.protocol.KeyHelper;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 20:54
 */
public class LicenceBody extends KeyHelper implements Serializable {

    @SerializedName("licenseTO")
    private LicenceBody.LicenceBodyInternal licenceBodyInternal;
    private String videoName;

    public LicenceBody(String videoName, int userId, int videoId, String delInd, String m3u8Path, String token, String licenceUrl, String localEncryptionKey, String localEncryptionIV) {
        super(m3u8Path, token, licenceUrl, localEncryptionKey, localEncryptionIV);
        this.licenceBodyInternal = new LicenceBody.LicenceBodyInternal(userId, videoId, delInd);
        this.videoName = videoName;
    }

    public String getVideoName() {
        return videoName;
    }


    public String jsonBody() {
        return (new Gson()).toJson(this);
    }

    public String getRequestType() {
        return "POST";
    }

    public int getVideoId() {
        return this.licenceBodyInternal.videoId;
    }

    public int getUserId() {
        return this.licenceBodyInternal.userId;
    }

    public String getUniqueKeyPathForVCB() {
        return String.valueOf(this.licenceBodyInternal.videoId);
    }

    public Class<? extends ILicenceWrapperContract> getLicenceResponseModelClass() {
        return LicenceModel.class;
    }

    public class LicenceBodyInternal implements Serializable {
        @SerializedName("userId")
        int userId;
        @SerializedName("videoId")
        int videoId;
        @SerializedName("delInd")
        String delInd;

        LicenceBodyInternal(int userId, int videoId, String delInd) {
            this.userId = userId;
            this.videoId = videoId;
            this.delInd = delInd;
        }
    }
}