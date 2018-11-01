package com.google.android.exoplayer2.demo.helpers;

import com.google.gson.annotations.SerializedName;
import com.vocabimate.protocol.ILicenceWrapperContract;

import java.io.Serializable;

/**
 * Created by Hisham on 16/Oct/2018 - 14:27
 */
public class LicenceModel implements ILicenceWrapperContract, Serializable {
    @SerializedName("licenseFile")
    private Licence licenseFile;

    public LicenceModel() {
    }

    public Licence getLicenseFile() {
        return this.licenseFile;
    }

    public LicenceModel setLicenseFile(Licence licenseFile) {
        this.licenseFile = licenseFile;
        return this;
    }
}
