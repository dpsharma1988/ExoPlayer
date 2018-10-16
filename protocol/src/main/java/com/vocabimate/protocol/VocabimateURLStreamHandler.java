package com.vocabimate.protocol;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created by Hisham on 15/Oct/2018 - 16:50
 */
class VocabimateURLStreamHandler extends URLStreamHandler {

    private final String protocol;

    public VocabimateURLStreamHandler(String protocol) {
        super();
        this.protocol = protocol;
    }

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        if ("vcb".equals(protocol)) {
            return new VocabimateHttpUrlConnection(url);
        } else {
            return new VocabimateUrlConnection(url);
        }
    }
}
