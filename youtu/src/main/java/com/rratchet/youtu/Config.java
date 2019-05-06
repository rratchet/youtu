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
 * 文件名称：Config.java
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

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;


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
final class Config {

    /**
     * The Preference file name.
     */
    static final String PREFERENCE_FILE_NAME = "rratchet-youtu-config";

    /**
     * The Key youtu app id.
     */
    static final String KEY_YOUTU_APP_ID = "YOUTU_APP_ID";
    /**
     * The Key youtu secret id.
     */
    static final String KEY_YOUTU_SECRET_ID = "YOUTU_SECRET_ID";
    /**
     * The Key youtu secret key.
     */
    static final String KEY_YOUTU_SECRET_KEY = "YOUTU_SECRET_KEY";


    /**
     * 过期时间：30 days
     */
    static final int EXPIRED_TIME = 2592000;

    /**
     * The Config.
     */
    static final Map<String, String> CONFIG = new HashMap<>();

    /**
     * Init.
     *
     * @param context the context
     */
    static void init(Context context) {
        if (BuildConfig.DEBUG) {
            init(context, "10008768", "AKIDN8lBPUYSHuNdkCAjhVhnhQwISHyumQvd", "jV6rTt782nU4hgaN3bkkXBbzGNI1a0oS");
        } else {
            init(context, null, null, null);
        }
    }

    /**
     * Init.
     *
     * @param context   the context
     * @param appId     the app id
     * @param secretId  the secret id
     * @param secretKey the secret key
     */
    static void init(Context context, String appId, String secretId, String secretKey) {

        CONFIG.clear();

        SharedPreferences preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        preferences.edit().clear().apply();

        getConfigValue(context, KEY_YOUTU_APP_ID, appId);
        getConfigValue(context, KEY_YOUTU_SECRET_ID, secretId);
        getConfigValue(context, KEY_YOUTU_SECRET_KEY, secretKey);
    }

    /**
     * Gets config value.
     *
     * @param context the context
     * @param key     the key
     * @return the config value
     */
    static String getConfigValue(Context context, String key) {
        return getConfigValue(context, key, null);
    }

    /**
     * Gets config value.
     *
     * @param context  the context
     * @param key      the key
     * @param defValue the def value
     * @return the config value
     */
    static String getConfigValue(Context context, String key, String defValue) {

        if (CONFIG.containsKey(key)) {
            return CONFIG.get(key);
        }

        SharedPreferences preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        String value = preferences.getString(key, "");
        if (value != null && value.length() > 0) {
            CONFIG.put(key, value);
            return value;
        }

        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(),
                    PackageManager.GET_META_DATA
            );
            Bundle bundle = info.metaData;
            if (bundle.containsKey(key)) {
                value = String.valueOf(bundle.get(key));
                if (value.length() > 0) {
                    CONFIG.put(key, value);
                    preferences.edit()
                            .putString(key, value)
                            .apply();
                    return value;
                }
            }

        } catch (Exception e) {
            if (defValue == null || defValue.isEmpty()) {
                String message = "Dear developer. Don't forget to configure <meta-data android:name=\"" + key + "\" android:value=\"{value}\"/> in your AndroidManifest.xml file.";
                Log.e(YouTu.TAG, message);
                e = new Exception(message);
                e.printStackTrace();
            }
        }

        CONFIG.put(key, defValue);

        return defValue;
    }
}
