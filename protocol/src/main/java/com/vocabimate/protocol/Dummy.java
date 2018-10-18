package com.vocabimate.protocol;

import java.io.Serializable;

/**
 * Created by Hisham on 18/Oct/2018 - 15:18
 */
public class Dummy implements Serializable{
    private KeyHelperModel keyHelper;

    public Dummy setKeyHelper(KeyHelperModel keyHelper) {
        this.keyHelper = keyHelper;
        return this;
    }

    public KeyHelperModel getKeyHelper() {
        return keyHelper;
    }
}
