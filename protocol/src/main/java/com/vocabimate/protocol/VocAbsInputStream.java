package com.vocabimate.protocol;

import java.io.InputStream;

/**
 * Created by Hisham on 15/Oct/2018 - 18:03
 */
abstract class VocAbsInputStream extends InputStream{
    protected InputStream in;
    abstract public void setInputStream(InputStream inputStream);
}
