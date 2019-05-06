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
 * 文件名称：YouTu.java
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

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.rratchet.youtu.service.Response;
import com.rratchet.youtu.service.api.Face;
import com.rratchet.youtu.service.api.Identity;

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
public class YouTu {

    /**
     * The constant TAG.
     */
    public static final String TAG = YouTu.class.getSimpleName();

    /**
     * The Api default service.
     */
    public static final String API_DEFAULT_SERVICE = "http://api.youtu.qq.com/youtu/";

    /**
     * The Api vip end point.
     */
    public static final String API_VIP_END_POINT = "https://vip-api.youtu.qq.com/youtu/";

    /**
     * The M context.
     */
    private Context mContext;

    /**
     * Instantiates a new You tu.
     */
    private YouTu() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static YouTu getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 初始化.
     *
     * @param context the context
     */
    public static void initSDK(Context context) {
        initSDK(context, null, null, null);
    }

    /**
     * 初始化.
     *
     * @param context   the context
     * @param appId     the app id
     * @param secretId  the secret id
     * @param secretKey the secret key
     */
    public static void initSDK(Context context, String appId, String secretId, String secretKey) {
        getInstance().init(context, appId, secretId, secretKey);
    }

    /**
     * Init.
     *
     * @param context   the context
     * @param appId     the app id
     * @param secretId  the secret id
     * @param secretKey the secret key
     */
    private void init(Context context, String appId, String secretId, String secretKey) {
        if (context instanceof Application) {
            mContext = context;
        } else {
            mContext = context.getApplicationContext();
        }

        Config.init(mContext, appId, secretId, secretKey);
    }

    /**
     * Gets app id.
     *
     * @return the app id
     */
    public String getAppId() {
        String appId = Config.getConfigValue(mContext, Config.KEY_YOUTU_APP_ID);
        return appId;
    }

    /**
     * 获取时效签名.
     *
     * @return the string
     */
    public String sign() {

        String appId = Config.getConfigValue(mContext, Config.KEY_YOUTU_APP_ID);
        String secretId = Config.getConfigValue(mContext, Config.KEY_YOUTU_SECRET_ID);
        String secretKey = Config.getConfigValue(mContext, Config.KEY_YOUTU_SECRET_KEY);

        StringBuffer sing = new StringBuffer();
        long expired = System.currentTimeMillis() / 1000 + Config.EXPIRED_TIME;
        int result = Sign.sign(appId, secretId, secretKey, expired, sing);

        if (result == 0) {
            return sing.toString();
        } else {
            Log.e(TAG, "YouTu sign failed.");
            return null;
        }
    }

    /**
     * Face face.
     *
     * @return the face
     */
    public Face<Response, com.rratchet.youtu.service.wrapper.face.Params> face() {
        return new com.rratchet.youtu.service.wrapper.face.Service();
    }

    /**
     * Identity identity.
     *
     * @return the identity
     */
    public Identity<Response, com.rratchet.youtu.service.wrapper.identity.Params> identity() {
        return new com.rratchet.youtu.service.wrapper.identity.Service();
    }

    /**
     * The type Singleton holder.
     */
    private static class SingletonHolder {
        /**
         * The constant INSTANCE.
         */
        private static final YouTu INSTANCE = new YouTu();
    }
}
