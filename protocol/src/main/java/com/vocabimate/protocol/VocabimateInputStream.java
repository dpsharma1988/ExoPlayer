package com.vocabimate.protocol;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hisham on 15/Oct/2018 - 17:55
 */
public class VocabimateInputStream extends VocAbsInputStream {
    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        in = inputStream;
    }
}
