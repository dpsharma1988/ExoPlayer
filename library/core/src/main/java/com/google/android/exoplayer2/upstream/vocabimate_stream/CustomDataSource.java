package com.google.android.exoplayer2.upstream.vocabimate_stream;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.vocab.KeyHelperModel;
import com.google.gson.Gson;
import com.vocabimate.protocol.LicenceModel;
import com.vocabimate.protocol.TokenDecryptionHelper;
import com.vocabimate.protocol.VocabimateStreamHandlerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLStreamHandlerFactory;

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

    @Override
    public long open(DataSpec dataSpec) throws HttpDataSourceException {
        return super.open(dataSpec);
    }

    public CustomDataSource(String userAgent, Predicate<String> contentTypePredicate) {
        super(userAgent, contentTypePredicate);
        init();
    }

    private void init() {
        maybeInstall(new VocabimateStreamHandlerFactory());
//        URL.setURLStreamHandlerFactory(new VocabimateStreamHandlerFactory());
    }

    public static void maybeInstall(URLStreamHandlerFactory factory) { // todo maybe not the perfect way, need to check this later.
        if(System.getProperty("com.vocabimate.streamHandlerFactoryInstalled") == null) {
            URL.setURLStreamHandlerFactory(factory);
            System.setProperty("com.vocabimate.streamHandlerFactoryInstalled", "true");
        }
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

//    /**
//     * Custom method for custom scheme.
//     */
//    private HttpURLConnection makeConnectionCustom() throws IOException {
//
//        if (this instanceof CustomDataSource) {
//            KeyHelperModel keyHelper = ((CustomDataSource) this).getKeyHelperModel();
//            if (keyHelper != null) {
//                String videoId = keyHelper.getVideoId();
//                if (videoId == null) {
//                    throw new NullPointerException("Video id is not set.");
//                }
//
//                URL keyUrl = null;
//                if (keyHelper.getKeyPath() == null) {
//                    String licenceUrl = keyHelper.getLicecnceUrl(); //"https://voca2hosting.firebaseapp.com/small_files/license_key_path_absolute.json";
//                    URL url = new URL(licenceUrl);
//
//                    // parse licence
//                    HttpURLConnection httpURLConnection = null;
//                    try {
//                        httpURLConnection = (HttpURLConnection) url.openConnection();
//                        String token = keyHelper.getToken();
//                        if(token != null && token.length() > 0) {
//                            httpURLConnection.setRequestProperty("access_token", token);
//                        }
//                        InputStream in = httpURLConnection.getInputStream();
//                        String result = readStream(in);
//                        VocaDataSourceHelper.LicenceModel licenceModel = new Gson()
//                                .fromJson(result, VocaDataSourceHelper.LicenceModel.class);
//                        if(licenceModel != null && licenceModel.getEncKeyByteString() != null) {
//                            TokenDecryptionHelper tokenDecryptionHelper = new TokenDecryptionHelper(keyHelper.getToken(), licenceModel.getEncKeyByteString());
//                            byte[] decrypt = tokenDecryptionHelper.decrypt();
//                            if (licenceModel.getPath() != null) {
//                                keyUrl = new URL(licenceModel.getPath());
//                            }
//                        }
//            /*InputStreamReader isw = new InputStreamReader(in);
//            int data = isw.read();
//            while (data != -1) {
//                char current = (char) data;
//                data = isw.read();
//                System.out.print(current);
//            }*/
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        if (httpURLConnection != null) {
//                            httpURLConnection.disconnect();
//                        }
//                    }
//                } else {
//                    keyUrl = new URL(keyHelper.getKeyPath());
//                }
//                HttpURLConnection connection = null;
////    keyUrl = new URL("http://54.152.186.92:60801/static/sample/enc.key"); // temp
//                if (keyUrl != null) {
//                    connection = (HttpURLConnection) keyUrl.openConnection();
//                    connection.setConnectTimeout(connectTimeoutMillis);
//                    connection.setReadTimeout(readTimeoutMillis);
//                    if (defaultRequestProperties != null) {
//                        for (Map.Entry<String, String> property : defaultRequestProperties.getSnapshot()
//                                .entrySet()) {
//                            connection.setRequestProperty(property.getKey(), property.getValue());
//                        }
//                    }
//                    for (Map.Entry<String, String> property : requestProperties.getSnapshot().entrySet()) {
//                        connection.setRequestProperty(property.getKey(), property.getValue());
//                    }
//                    connection.setRequestProperty("User-Agent", userAgent);
//                    connection.setRequestMethod("GET");
////    if(!TextUtils.isEmpty(TokenManager.getToken())) {
//                    if (this instanceof CustomDataSource) {
//                        KeyHelperModel keyHelperModel = ((CustomDataSource) this).getKeyHelperModel();
//                        if (keyHelperModel != null) {
//                            String token2 = keyHelper.getToken();
//                            if(token2 != null && token2.length() > 0) {
//                                connection.setRequestProperty("access_token", token2);
//                            }
//                        }
//                    }
//
////    }
//                    Log.d(TAG, "ResponseCode: " + connection.getResponseCode());
//                }
//                return connection;
//            }
//        }
//        return connection;
//    }


    private int parseData(byte[] buffer) throws IOException {
        KeyHelperModel keyHelper = ((CustomDataSource) this).getKeyHelperModel();
        if (keyHelper != null) {
            String videoId = keyHelper.getVideoId();
            if (videoId == null) {
                throw new NullPointerException("Video id is not set.");
            }
            String licenceUrl = keyHelper.getLicecnceUrl(); //"https://voca2hosting.firebaseapp.com/small_files/license_key_path_absolute.json";
            URL url = new URL(licenceUrl);

            // parse licence
            HttpURLConnection licenseConnection = null;
            try {
                licenseConnection = (HttpURLConnection) url.openConnection();
                String token = keyHelper.getToken();
                if(token != null && token.length() > 0) {
                    licenseConnection.setRequestProperty("access_token", token);
                }
                InputStream in = licenseConnection.getInputStream();
                String result = readStream(in);
                LicenceModel licenceModel = new Gson().fromJson(result, LicenceModel.class);
                if(licenceModel != null && licenceModel.getLicenseFile().getDecryptionKey() != null) {
                    TokenDecryptionHelper tokenDecryptionHelper = new TokenDecryptionHelper(keyHelper.getToken(), licenceModel.getLicenseFile().getDecryptionKey());
                    byte[] decrypt = tokenDecryptionHelper.decrypt();
                    for (int i = 0; i < decrypt.length; i++) {
                        buffer[i] = decrypt[i];
                    }
                    return 16;
                }

        /*InputStreamReader isw = new InputStreamReader(in);
        int data = isw.read();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            System.out.print(current);
        }*/
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (licenseConnection != null) {
                    licenseConnection.disconnect();
                }
            }
        }
        return -1;
    }



    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }


}
