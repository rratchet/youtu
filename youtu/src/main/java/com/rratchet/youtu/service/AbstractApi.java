/*
 * Copyright (c) 2019. RRatChet Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 项目名称：rratchet-youtu-trunk
 * 模块名称：youtu
 *
 * 文件名称：AbstractApi.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 18:08:13
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-06 18:12:05
 * 修改备注：
 */

package com.rratchet.youtu.service;

import com.rratchet.youtu.YouTu;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        description
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public class AbstractApi {

    /**
     * The M base url.
     */
    private String mBaseUrl;
    /**
     * The Is enable security access.
     */
    private boolean isEnableSecurityAccess;

    /**
     * Instantiates a new api provider.
     *
     * @param baseUrl the base url
     */
    public AbstractApi(String baseUrl) {
        this.mBaseUrl = baseUrl;
        this.isEnableSecurityAccess = baseUrl.startsWith("https");
    }

    /**
     * Request string.
     *
     * @param requestMethod the request method
     * @param options       the options
     * @return the string
     * @throws Exception the exception
     */
    protected String request(String requestMethod, RequestOptions options) throws Exception {
        if (isEnableSecurityAccess) {
            return executeHttpsRequest(requestMethod, options);
        } else {
            return executeHttpRequest(requestMethod, options);
        }
    }

    /**
     * Execute http request string.
     *
     * @param requestMethod the request method
     * @param options       the options
     * @return the string
     * @throws Exception the exception
     */
    private String executeHttpRequest(String requestMethod, RequestOptions options) throws Exception {

        String appId = YouTu.getInstance().getAppId();
        String sing = YouTu.getInstance().sign();

        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");

        URL url = new URL(mBaseUrl + requestMethod);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // set header
        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "*/*");
//		connection.setRequestProperty("Host", "api.youtu.qq.com");
        connection.setRequestProperty("user-agent", "youtu-android-sdk");
        connection.setRequestProperty("Authorization", sing);

//		connection.setConnectTimeout(30000);
//		connection.setReadTimeout(30000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "text/json");
        connection.connect();

        // POST请求
        DataOutputStream out = new DataOutputStream(
                connection.getOutputStream());

        options.put("app_id", appId);
        String json = options.toJson();
        out.write(json.getBytes("utf-8"));
        //out.writeBytes(postData.toString());
        out.flush();
        out.close();
        // 读取响应
        InputStream isss = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                isss));
        String lines;
        StringBuffer resposeBuffer = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            resposeBuffer.append(lines);
        }
        reader.close();
        // 断开连接
        connection.disconnect();

        String response = resposeBuffer.toString();

        return response;
    }

    /**
     * Execute https request string.
     *
     * @param requestMethod the request method
     * @param options       the options
     * @return the string
     * @throws Exception the exception
     */
    private String executeHttpsRequest(String requestMethod, RequestOptions options) throws Exception {

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());

        String appId = YouTu.getInstance().getAppId();
        String sign = YouTu.getInstance().sign();

        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");

        URL url = new URL(mBaseUrl + requestMethod);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(context.getSocketFactory());
        connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
        // set header
        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "*/*");
        // connection.setRequestProperty("Host", "youtu.api.qcloud.com");
        connection.setRequestProperty("user-agent", "youtu-android-sdk");
        connection.setRequestProperty("Authorization", sign);

        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "text/json");
        connection.connect();

        OutputStream outaa = connection.getOutputStream();
        // POST请求
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        options.put("app_id", appId);
        out.write(options.toJson().getBytes("utf-8"));
        // 刷新、关闭
        out.flush();
        out.close();

        // 读取响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer resposeBuffer = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            resposeBuffer.append(lines);
        }
        reader.close();
        // 断开连接
        connection.disconnect();

        String response = resposeBuffer.toString();

        return response;
    }


    /**
     * The type Trust any trust manager.
     */
    private static class TrustAnyTrustManager implements X509TrustManager {

        /**
         * Check client trusted.
         *
         * @param chain    the chain
         * @param authType the auth type
         * @throws CertificateException the certificate exception
         */
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        /**
         * Check server trusted.
         *
         * @param chain    the chain
         * @param authType the auth type
         * @throws CertificateException the certificate exception
         */
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        /**
         * Get accepted issuers x 509 certificate [ ].
         *
         * @return the x 509 certificate [ ]
         */
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    /**
     * The type Trust any hostname verifier.
     */
    private static class TrustAnyHostnameVerifier implements HostnameVerifier {

        /**
         * Verify boolean.
         *
         * @param hostname the hostname
         * @param session  the session
         * @return the boolean
         */
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
