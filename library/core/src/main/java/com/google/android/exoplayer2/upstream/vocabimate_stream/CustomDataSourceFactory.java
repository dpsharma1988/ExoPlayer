/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer2.upstream.vocabimate_stream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.vocab.KeyHelperModel;

/**
 * A {@link Factory} that produces {@link DefaultHttpDataSource} instances.
 */
public final class CustomDataSourceFactory extends BaseFactory {

    private final String userAgent;
    private final TransferListener<? super DataSource> listener;
    private final int connectTimeoutMillis;
    private final int readTimeoutMillis;
    private final boolean allowCrossProtocolRedirects;
    private KeyHelperModel keyHelperModel;

    /**
     * Constructs a DefaultHttpDataSourceFactory. Sets {@link
     * DefaultHttpDataSource#DEFAULT_CONNECT_TIMEOUT_MILLIS} as the connection timeout, {@link
     * DefaultHttpDataSource#DEFAULT_READ_TIMEOUT_MILLIS} as the read timeout and disables
     * cross-protocol redirects.
     *
     * @param userAgent The User-Agent string that should be used.
     */
    public CustomDataSourceFactory(String userAgent, KeyHelperModel keyHelperModel) {
        this(userAgent, null, keyHelperModel);
    }

    /**
     * Constructs a DefaultHttpDataSourceFactory. Sets {@link
     * DefaultHttpDataSource#DEFAULT_CONNECT_TIMEOUT_MILLIS} as the connection timeout, {@link
     * DefaultHttpDataSource#DEFAULT_READ_TIMEOUT_MILLIS} as the read timeout and disables
     * cross-protocol redirects.
     *
     * @param userAgent The User-Agent string that should be used.
     * @param listener An optional listener.
     */


    public CustomDataSourceFactory(
            String userAgent, TransferListener<? super DataSource> listener, KeyHelperModel keyHelperModel) {
        this(userAgent, listener, DefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                DefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, false, keyHelperModel);
    }

    /**
     * @param userAgent                   The User-Agent string that should be used.
     * @param listener                    An optional listener.
     * @param connectTimeoutMillis        The connection timeout that should be used when requesting remote
     *                                    data, in milliseconds. A timeout of zero is interpreted as an infinite timeout.
     * @param readTimeoutMillis           The read timeout that should be used when requesting remote data, in
     *                                    milliseconds. A timeout of zero is interpreted as an infinite timeout.
     * @param allowCrossProtocolRedirects Whether cross-protocol redirects (i.e. redirects from HTTP
     *                                    to HTTPS and vice versa) are enabled.
     */
    public CustomDataSourceFactory(String userAgent,
                                   TransferListener<? super DataSource> listener, int connectTimeoutMillis,
                                   int readTimeoutMillis, boolean allowCrossProtocolRedirects, KeyHelperModel keyHelperModel) {
        this.userAgent = userAgent;
        this.listener = listener;
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.allowCrossProtocolRedirects = allowCrossProtocolRedirects;
        this.keyHelperModel = keyHelperModel;
    }

    @Override
    protected DefaultHttpDataSource createDataSourceInternal(
            HttpDataSource.RequestProperties defaultRequestProperties) {
        CustomDataSource defaultHttpDataSource = new CustomDataSource(userAgent, null,
                listener, connectTimeoutMillis,
                readTimeoutMillis, allowCrossProtocolRedirects, defaultRequestProperties).setKeyHelperModel(keyHelperModel);
        return defaultHttpDataSource;
    }

}
