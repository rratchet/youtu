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
 * 文件名称：RequestOptions.java
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

import org.json.JSONObject;

import java.util.LinkedHashMap;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        request options.
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public class RequestOptions {

    /**
     * The Name value pairs.
     */
    private final LinkedHashMap<String, Object> nameValuePairs;

    /**
     * Instantiates a new Request options.
     */
    public RequestOptions() {
        nameValuePairs = new LinkedHashMap<>();
    }

    /**
     * Put request options.
     *
     * @param key   the key
     * @param value the value
     * @return the request options
     */
    public RequestOptions put(String key, Object value) {
        nameValuePairs.put(key, value);
        return this;
    }

    /**
     * Target linked hash map.
     *
     * @return the linked hash map
     */
    public LinkedHashMap<String, Object> target() {
        return nameValuePairs;
    }

    /**
     * Get t.
     *
     * @param <T> the type parameter
     * @param key the key
     * @return the t
     */
    public <T> T get(String key) {
        Object value = nameValuePairs.get(key);
        if (value != null) {
            try {
                return (T) value;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJson() {
        JSONObject jsonObject = new JSONObject(nameValuePairs);
        return jsonObject.toString();
    }
}
