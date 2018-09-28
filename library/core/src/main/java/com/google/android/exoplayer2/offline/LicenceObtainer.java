package com.google.android.exoplayer2.offline;

import android.util.Log;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.vocabimate_stream.VocaDataSourceHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class LicenceObtainer {

    private int connectTimeoutMillis;
    private ILicenceData listener;
    private int readTimeoutMillis;
    private HttpDataSource.RequestProperties defaultRequestProperties;
    private HttpDataSource.RequestProperties requestProperties;
    private String userAgent;

    public LicenceObtainer(int connectTimeoutMillis, ILicenceData listener) {
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.listener = listener;
    }

    public void getLicence() throws IOException
    {
        String licenceUrl = "https://voca2hosting.firebaseapp.com/small_files/license_key_path_absolute.json";
        URL url = new URL(licenceUrl);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(connectTimeoutMillis);
        urlConnection.setReadTimeout(readTimeoutMillis);
        /*if (defaultRequestProperties != null) {
            for (Map.Entry<String, String> property : defaultRequestProperties.getSnapshot().entrySet()) {
                connection.setRequestProperty(property.getKey(), property.getValue());
            }
        }
        for (Map.Entry<String, String> property : requestProperties.getSnapshot().entrySet()) {
            connection.setRequestProperty(property.getKey(), property.getValue());
        }
        connection.setRequestProperty("User-Agent", userAgent);
        connection.setRequestMethod("GET");
//    if(!TextUtils.isEmpty(TokenManager.getToken())) {
//      connection.setRequestProperty("token", TokenManager.getToken());
//    }
        Log.d(TAG, "hisham: " + connection.getResponseCode());
        return connection;*/
        try {
            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            String result = readStream(in);
            listener.onLicenceReceived(new Gson().fromJson(result, VocaDataSourceHelper.LicenceModel.class));

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
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
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


    interface ILicenceData {
        public void onLicenceReceived(VocaDataSourceHelper.LicenceModel licenceModel);
    }
}
