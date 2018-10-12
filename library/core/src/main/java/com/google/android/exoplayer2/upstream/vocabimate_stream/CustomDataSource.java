package com.google.android.exoplayer2.upstream.vocabimate_stream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.vocab.KeyHelperModel;

/**
 * Created by Hisham on 12/Oct/2018 - 13:55
 */
public final class CustomDataSource extends DefaultHttpDataSource {

    private KeyHelperModel keyHelperModel;

    public CustomDataSource setKeyHelperModel(KeyHelperModel keyHelperModel) {
        this.keyHelperModel = keyHelperModel;
        return this;
    }

    public KeyHelperModel getKeyHelperModel() {
        return keyHelperModel;
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate) {
        super(userAgent, contentTypePredicate);
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener) {
        super(userAgent, contentTypePredicate, listener);
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener, int connectTimeoutMillis, int readTimeoutMillis) {
        super(userAgent, contentTypePredicate, listener, connectTimeoutMillis, readTimeoutMillis);
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate, TransferListener<? super DefaultHttpDataSource> listener, int connectTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects, RequestProperties defaultRequestProperties) {
        super(userAgent, contentTypePredicate, listener, connectTimeoutMillis, readTimeoutMillis, allowCrossProtocolRedirects, defaultRequestProperties);
    }
}
