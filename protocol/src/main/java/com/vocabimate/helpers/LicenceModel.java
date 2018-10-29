package com.vocabimate.helpers;

import com.google.gson.annotations.SerializedName;
import com.vocabimate.protocol.ILicenceWrapperContract;

/**
 * Created by Hisham on 16/Oct/2018 - 14:27
 */
public class LicenceModel implements ILicenceWrapperContract {

    @SerializedName("licenseFile")
    private Licence licenseFile;

    public Licence getLicenseFile() {
        return licenseFile;
    }

    public LicenceModel setLicenseFile(Licence licenseFile) {
        this.licenseFile = licenseFile;
        return this;
    }

}
