package com.google.android.exoplayer2.upstream.vocabimate_stream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Hisham on 21/Sep/2018 - 17:13
 */
public class VocaDataSourceHelper {

    private Gson gson;

//    public void parseData(URLConnection connection,
//        DataSpec dataSpec) throws IOException {
//
//        connection.connect();
//        InputStream stream = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        StringBuffer buffer = new StringBuffer();
//        String line;
//        while ((line = reader.readLine()) != null){
//            buffer.append(line);
//        }
//
//        String finalJson = buffer.toString();
//        try {
//            JSONObject parentObject = new JSONObject(finalJson);
//
//            LicenceModel licenceModel = gson.fromJson(parentObject.toString(), LicenceModel.class);
//            String keyPath = licenceModel.getPath();
//            dataSpec.uri = Uri.parse(keyPath);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//    }

    public class LicenceModel {
        @SerializedName("key_path")
        private String path;
        @SerializedName("key")
        private String key;

        public String getPath() {
            return path;
        }

        public LicenceModel setPath(String path) {
            this.path = path;
            return this;
        }

        public String getKey() {
            return key;
        }

        public LicenceModel setKey(String key) {
            this.key = key;
            return this;
        }
    }

}
