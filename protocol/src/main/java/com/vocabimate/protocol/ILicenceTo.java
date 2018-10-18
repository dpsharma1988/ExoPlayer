package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 20:37
 */
public interface ILicenceTo extends Serializable {
    String jsonBody();
    String getType();
    String getToken();
    String getLicenceUrl();
    String getM3U8Path();
}
