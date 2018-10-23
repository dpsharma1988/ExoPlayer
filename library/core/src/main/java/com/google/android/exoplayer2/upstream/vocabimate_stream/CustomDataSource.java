package com.google.android.exoplayer2.upstream.vocabimate_stream;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Predicate;
import com.vocabimate.protocol.ILicenceTo;
import com.vocabimate.protocol.VocabimateStreamHandlerFactory;

import java.net.URL;
import java.net.URLStreamHandlerFactory;

/**
 * Created by Hisham on 12/Oct/2018 - 13:55
 */
public final class CustomDataSource extends DefaultHttpDataSource {

    private ILicenceTo licence;

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate) {
        super(userAgent, contentTypePredicate);
        init();
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener) {
        super(userAgent, contentTypePredicate, listener);
        init();
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener, int connectTimeoutMillis, int readTimeoutMillis) {
        super(userAgent, contentTypePredicate, listener, connectTimeoutMillis, readTimeoutMillis);
        init();
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener, int connectTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects, RequestProperties defaultRequestProperties) {
        super(userAgent, contentTypePredicate, listener, connectTimeoutMillis, readTimeoutMillis, allowCrossProtocolRedirects, defaultRequestProperties);
        init();
    }
    private void init() {
        maybeInstall(new VocabimateStreamHandlerFactory());
//        URL.setURLStreamHandlerFactory(new VocabimateStreamHandlerFactory());
    }
    public static void maybeInstall(URLStreamHandlerFactory factory) { // todo maybe not the perfect way, need to check this later.
        if (System.getProperty("com.vocabimate.streamHandlerFactoryInstalled") == null) {
            URL.setURLStreamHandlerFactory(factory);
            System.setProperty("com.vocabimate.streamHandlerFactoryInstalled", "true");
        }
    }

    public ILicenceTo getKeyHelperModel() {
        return licence;
    }

    public CustomDataSource setKeyHelperModel(ILicenceTo licence) {
        this.licence = licence;
        return this;
    }

    @Override
    public long open(DataSpec dataSpec) throws HttpDataSourceException {
        return super.open(dataSpec);
    }


}
