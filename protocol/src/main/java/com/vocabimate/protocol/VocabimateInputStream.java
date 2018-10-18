package com.vocabimate.protocol;

import java.io.IOException;
import java.io.InputStream;

/**
 * Class is being used using reflection
 * @see VocabimateHttpUrlConnection
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
