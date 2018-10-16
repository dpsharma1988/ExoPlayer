package com.vocabimate.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Hisham on 15/Oct/2018 - 16:58
 */
class VocabimateUrlConnection extends URLConnection {

    protected VocAbsInputStream vocAbsInputStream;

    @Override
    public void connect() throws IOException {


        InputStream is = null; // todo
        vocAbsInputStream.setInputStream(is);

        // todo need to hit server here in real, maybe
        connected = true;
    }

    public VocabimateUrlConnection(URL url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if(!connected){
            connect();
        }
        return vocAbsInputStream;
    }
}
