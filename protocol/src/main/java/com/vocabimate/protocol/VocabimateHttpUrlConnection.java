package com.vocabimate.protocol;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Hisham on 15/Oct/2018 - 16:58
 */
public class VocabimateHttpUrlConnection extends HttpURLConnection {

    protected VocAbsInputStream vocAbsInputStream;
    private ILicenceTo licence;

    /**
     * @see com.vocabimate.protocol.VocabimateInputStream VocabimateInputStream
     */
    public VocabimateHttpUrlConnection(URL url) throws IOException {
        super(url);
        try {
            String classname = "com.vocabimate.protocol." + "VocabimateInputStream";
            vocAbsInputStream = (VocAbsInputStream) Class.forName(classname).newInstance();
        } catch (Exception e) {
            throw new IOException("Class Not Found: " + e);
        }
    }

    @Override
    public void connect() throws IOException {

        // todo Need to fix things here, not getting token and licence url on older phones.
        String licence_url = licence.getLicenceUrl();//getRequestProperty("licence_url");
        String token = licence.getToken();//getRequestProperty("access_token");
//        if (licence_url == null) {
//            throw new Error("Licence url is not provided in header, please set 'licence_url' just like access_token");
//        }
//        if (token == null) {
//            throw new Error("Access Token is null, please set access_token in header");
//        }
        URL url = new URL(licence_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if(licence.getType() == null) {
            connection.setRequestMethod("POST"); // default
        } else {
            connection.setRequestMethod(licence.getType());
        }
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("access_token", token);
        connection.setRequestProperty("Content-Type", "application/json");

        if(licence.jsonBody() != null) {
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(licence.jsonBody());
            wr.flush();
        }

        if (token != null) {
            String result = readStream(connection.getInputStream());
            LicenceModel licenceModel = new Gson().fromJson(result, LicenceModel.class);
            InputStream stream = null;
            if (licenceModel != null && licenceModel.getLicenseFile() != null && licenceModel.getLicenseFile().getDecryptionKey() != null) {
                TokenDecryptionHelper tokenDecryptionHelper = new TokenDecryptionHelper(token, licenceModel.getLicenseFile().getDecryptionKey());
                byte[] decrypt = tokenDecryptionHelper.decrypt();
                stream = new ByteArrayInputStream(decrypt);
//            for (int i = 0; i < decrypt.length; i++) {
//                buffer[i] = decrypt[i];
//            }
                vocAbsInputStream.setInputStream(stream);
            }
        }
        connected = true;
        responseCode = 200;
    }

    @Override
    public int getResponseCode() throws IOException {
        return responseCode;
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

    @Override
    public String getContentType() {
        return "application/pgp-keys";
    }

    @Override
    public void disconnect() {
        vocAbsInputStream = null;
    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (!connected) {
            connect();
        }
        return vocAbsInputStream;
    }

    public void setKeyHelper(ILicenceTo licence) {
        this.licence = licence;
    }
}
