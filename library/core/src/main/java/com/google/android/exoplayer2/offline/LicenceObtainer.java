package com.google.android.exoplayer2.offline;

public class LicenceObtainer {

//    private int connectTimeoutMillis;
//    private ILicenceData listener;
//    private int readTimeoutMillis;
//    private HttpDataSource.RequestProperties defaultRequestProperties;
//    private HttpDataSource.RequestProperties requestProperties;
//    private String userAgent;
//
//    public LicenceObtainer(int connectTimeoutMillis, ILicenceData listener) {
//        this.connectTimeoutMillis = connectTimeoutMillis;
//        this.listener = listener;
//    }
//
//    public void getLicence() throws IOException
//    {
//        String licenceUrl = "https://voca2hosting.firebaseapp.com/small_files/license_key_path_absolute.json";
//        URL url = new URL(licenceUrl);
//
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setConnectTimeout(connectTimeoutMillis);
//        urlConnection.setReadTimeout(readTimeoutMillis);
//        /*if (defaultRequestProperties != null) {
//            for (Map.Entry<String, String> property : defaultRequestProperties.getSnapshot().entrySet()) {
//                connection.setRequestProperty(property.getKey(), property.getValue());
//            }
//        }
//        for (Map.Entry<String, String> property : requestProperties.getSnapshot().entrySet()) {
//            connection.setRequestProperty(property.getKey(), property.getValue());
//        }
//        connection.setRequestProperty("User-Agent", userAgent);
//        connection.setRequestMethod("GET");
////    if(!TextUtils.isEmpty(TokenManager.getToken())) {
////      connection.setRequestProperty("token", TokenManager.getToken());
////    }
//        Log.d(TAG, "hisham: " + connection.getResponseCode());
//        return connection;*/
//        try {
//            urlConnection = (HttpURLConnection) url
//                    .openConnection();
//
//            InputStream in = urlConnection.getInputStream();
//
//            String result = readStream(in);
//            listener.onLicenceReceived(new Gson().fromJson(result, LicenceModel.class));
//
//            /*InputStreamReader isw = new InputStreamReader(in);
//            int data = isw.read();
//            while (data != -1) {
//                char current = (char) data;
//                data = isw.read();
//                System.out.print(current);
//            }*/
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (urlConnection != null) {
//                urlConnection.disconnect();
//            }
//        }
//    }
//
//    private String readStream(InputStream in) {
//        BufferedReader reader = null;
//        StringBuffer response = new StringBuffer();
//        try {
//            reader = new BufferedReader(new InputStreamReader(in));
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return response.toString();
//    }
//
//
//    interface ILicenceData {
//        public void onLicenceReceived(LicenceModel licenceModel);
//    }
}
