package com.hummingbird.tag.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 发送http get/post请求工具类
 * Created by dingxuefei on 2014/6/20.
 */
public class HttpPostUtils {

    public final static int DEFAULT_BUFFER_SIZE = 1024;

    private static final int CONNECT_TIMEOUT =  10000;
    private static final int READ_TIMEOUT = 10000;

    /**
     * 发送http get请求
     * @param urladdress
     * @return
     * @throws Exception
     */
    public static String sendHttpGet(String urladdress) {
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urladdress);

            uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.setConnectTimeout(CONNECT_TIMEOUT); 
            uc.setReadTimeout(READ_TIMEOUT);
            uc.connect();
            StringWriter lines = new StringWriter();
            try {
                InputStreamReader reader = new InputStreamReader(uc.getInputStream());
                char[] cbuf = new char[DEFAULT_BUFFER_SIZE];
                int n;
                while((n = reader.read(cbuf))!=-1) lines.write(cbuf, 0, n);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lines.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (uc != null && uc.getInputStream() != null) {
                    uc.getInputStream().close();// 只释放实例资源，不会影响持久连接
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }



    /**
     * 发送http Post请求
     * @param urladdress  地址
     * @return
     */
    public static String sendHttpPost(String urladdress, String param) throws Exception {
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urladdress);

            uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setInstanceFollowRedirects(true); // 不允许重定向
            uc.setRequestMethod("POST");
            uc.setConnectTimeout(CONNECT_TIMEOUT); 
            uc.setReadTimeout(READ_TIMEOUT); 
            uc.getOutputStream().write(param.getBytes());
            uc.connect();
            String lines = "";
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                while (reader.ready()) {
                    lines += reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lines;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (uc != null && uc.getInputStream() != null) {
                uc.getInputStream().close();// 只释放实例资源，不会影响持久连接
            }
        }
        return "";
    }

}
