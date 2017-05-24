package com.example.echolin.week7.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by echolin on 2017/5/23.
 */

public class HttpUtils {


    public static String infoDownLoad(String path) {
        HttpURLConnection conn = null;
        String result = null;
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                int len;
                byte[] buffer = new byte[1024];
                is = conn.getInputStream();
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                    baos.flush();
                }
                result = baos.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            conn.disconnect();
        }
        return result;
    }
}
