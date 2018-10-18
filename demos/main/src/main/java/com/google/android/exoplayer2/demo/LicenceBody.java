package com.google.android.exoplayer2.demo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vocabimate.protocol.KeyHelper;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 20:54
 */
public class LicenceBody extends KeyHelper implements Serializable {

    @SerializedName("licenseTO")
    private LicenceBodyInternal licenceBodyInternal;

    public LicenceBody(int userId, int videoId, String delInd, String m3u8Path, String token, String licenceUrl) {
        super(m3u8Path, token, licenceUrl);
        licenceBodyInternal = new LicenceBodyInternal(userId, videoId, delInd);
    }

    @Override
    public String jsonBody() {
        return new Gson().toJson(this);
    }

    @Override
    public String getType() {
        return "POST";
    }


    private class LicenceBodyInternal implements Serializable {
        @SerializedName("userId")
        int userId;
        @SerializedName("videoId")
        int videoId;
        @SerializedName("delInd")
        String delInd;

        public LicenceBodyInternal(int userId, int videoId, String delInd) {
            this.userId = userId;
            this.videoId = videoId;
            this.delInd = delInd;
        }
    }
}
