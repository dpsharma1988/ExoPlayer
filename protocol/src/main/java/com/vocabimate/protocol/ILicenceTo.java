package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 20:37
 */
public interface ILicenceTo extends Serializable {
    String jsonBody();
    /**
     * @return request type, GET, POST etc.
     */
    String getRequestType();
    String getToken();
    String getLicenceUrl();
    String getUniqueKeyPathForVCB(); // Every Key must have a unique path, otherwise keys may get replaced or 2nd key with same path may not download
    String getLocalEncryptionKey();
    String getLocalEncryptionIV();
    // this could be null
    ILicenceWrapperContract getLicenceWrapperContract();
    int getVideoId();
    Class<? extends ILicenceWrapperContract> getLicenceResponseModelClass();

}
