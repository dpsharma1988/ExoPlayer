package com.vocabimate.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainClass {

    public static void main(String args[]){
        System.out.print("Hello");

        URL.setURLStreamHandlerFactory(new VocabimateStreamHandlerFactory());
        try {
            URL url = new URL("vcb://");
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            int i = inputStream.read();
            while(i != -1){
                System.out.print(i);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
