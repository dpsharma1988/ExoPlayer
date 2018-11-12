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
    private ILicenceTo licenceTo;

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

        String licence_url = licenceTo.getLicenceUrl();//getRequestProperty("licence_url");
        String token = licenceTo.getToken();//getRequestProperty("access_token");
//        if (licence_url == null) {
//            throw new Error("Licence url is not provided in header, please set 'licence_url' just like access_token");
//        }
//        if (token == null) {
//            throw new Error("Access Token is null, please set access_token in header");
//        }
        URL url = new URL(licence_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String requestType = licenceTo.getRequestType();
        if(requestType == null) {
            connection.setRequestMethod("POST"); // default
        } else {
            connection.setRequestMethod(requestType);
        }
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("access_token", token);
        connection.setRequestProperty("Content-Type", "application/json");

        String requestBody = licenceTo.jsonBody();
        if(requestBody != null) {
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(requestBody);
            wr.flush();
        }

        if (token != null) {
            String result = readStream(connection.getInputStream());
            ILicenceWrapperContract licenceWrapper = new Gson().fromJson(result, licenceTo.getLicenceResponseModelClass());
            InputStream stream;
            if (licenceWrapper != null) {
                if(licenceTo instanceof KeyHelper) {
                    ((KeyHelper)licenceTo).setLicenceWrapperContract(licenceWrapper);
                }
                ILicenceContract licenseFile = licenceWrapper.getLicenseFile();
                if(licenseFile != null && licenseFile.getDecryptionKey() != null) {
                    TokenDecryptionHelper tokenDecryptionHelper = new TokenDecryptionHelper(token, licenseFile.getDecryptionKey());
                    byte[] decrypt = tokenDecryptionHelper.decrypt();
                    stream = new ByteArrayInputStream(decrypt);
                    vocAbsInputStream.setInputStream(stream);
                }
            } else {
                connected = false;
                responseCode = 500;
                return;
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
            String line;
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
        this.licenceTo = licence;
    }
}
