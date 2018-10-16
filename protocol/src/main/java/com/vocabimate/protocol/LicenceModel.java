package com.vocabimate.protocol;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Hisham on 16/Oct/2018 - 14:27
 */
public class LicenceModel {

    @SerializedName("licenseFile")
    private Licence licenseFile;

    public Licence getLicenseFile() {
        return licenseFile;
    }

    public LicenceModel setLicenseFile(Licence licenseFile) {
        this.licenseFile = licenseFile;
        return this;
    }

    public class Licence{

        private int userId;
        private int videoId;
        private String decryptionKey;
        private Date validateDt;
        private Date createDt;
        private String createUserId;
        private Date updateDt;
        private String updateUserId;
        private String delInd;

        public Licence() { //no operation
        }

        public Licence(int userId, int videoId) {
            super();
            this.userId = userId;
            this.videoId = videoId;
        }

        public Licence(int userId, int videoId, Date validateDt, Date createDt, String createUserId, Date updateDt, String updateUserId, String delInd) {
            super();
            this.userId = userId;
            this.videoId = videoId;
            this.validateDt = validateDt;
            this.createDt = createDt;
            this.createUserId = createUserId;
            this.updateDt = updateDt;
            this.updateUserId = updateUserId;
            this.delInd = delInd;
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

        public void setDecryptionKey(String decryptionKey) {
            this.decryptionKey = decryptionKey;
        }

    }

}
