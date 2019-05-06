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
 * 文件名称：Sign.java
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

package com.rratchet.youtu;

import java.util.Random;

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
final class Sign {

    /**
     * 时效性签名
     *
     * @param appId     http://open.youtu.qq.com/上申请的业务ID
     * @param secretId  http://open.youtu.qq.com/上申请的密钥id
     * @param secretKey http://open.youtu.qq.com/上申请的密钥key
     * @param expired   签名过期时间
     * @param buffer    生成的签名
     * @return 0表示成功 int
     */
    static int sign(String appId, String secretId, String secretKey, long expired, StringBuffer buffer) {
        String userId = null;
        if (BuildConfig.DEBUG) {
            userId = "3041722595";
        }
        return sign(appId, secretId, secretKey, userId, expired, buffer);
    }

    /**
     * 时效性签名
     *
     * @param appId     http://open.youtu.qq.com/上申请的业务ID
     * @param secretId  http://open.youtu.qq.com/上申请的密钥id
     * @param secretKey http://open.youtu.qq.com/上申请的密钥key
     * @param userId    业务账号系统,没有可以不填
     * @param expired   签名过期时间
     * @param buffer    生成的签名
     * @return 0表示成功 int
     */
    static int sign(String appId, String secretId, String secretKey, String userId, long expired, StringBuffer buffer) {


        if (empty(secretId) || empty(secretKey)) {
            return -1;
        }

        if (!empty(userId)) {
            if (userId.length() > 64) {
                return -2;
            }
        } else {
            userId = "";
        }

        long now = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        StringBuilder singData = new StringBuilder();
        singData.append("a=").append(appId)
                .append("&")
                .append("k=").append(secretId)
                .append("&")
                .append("e=").append(expired)
                .append("&")
                .append("t=").append(now)
                .append("&")
                .append("r=").append(rdm)
                .append("&")
                .append("u=").append(userId);
//        String data = "a=" + appId + "&k=" + secretId + "&e=" + expired + "&t=" + now + "&r=" + rdm + "&u=" + puserid;//+ "&f=" + fileid.toString();

        String data = singData.toString();
        byte[] bin = hashHmac(data, secretKey);

        byte[] all = new byte[bin.length + data.getBytes().length];
        System.arraycopy(bin, 0, all, 0, bin.length);
        System.arraycopy(data.getBytes(), 0, all, bin.length, data.getBytes().length);

        buffer.append(Base64Util.encode(all));

        return 0;
    }

    /**
     * Hash hmac byte [ ].
     *
     * @param data      the data text
     * @param accessKey the access key
     * @return the byte [ ]
     */
    private static byte[] hashHmac(String data, String accessKey) {

        try {
            return HMACSHA1.getSignature(data, accessKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Empty boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public static boolean empty(String s) {
        return s == null || s.trim().isEmpty() || "null".equals(s.trim());
    }
}
