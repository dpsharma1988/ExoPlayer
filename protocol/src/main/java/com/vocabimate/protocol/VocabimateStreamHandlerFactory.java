package com.vocabimate.protocol;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Created by Hisham on 15/Oct/2018 - 16:44
 */
public class VocabimateStreamHandlerFactory implements URLStreamHandlerFactory {
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        if("vcb".equals(protocol)) {
            return new VocabimateURLStreamHandler(protocol);
        }
        return null;
    }
}
