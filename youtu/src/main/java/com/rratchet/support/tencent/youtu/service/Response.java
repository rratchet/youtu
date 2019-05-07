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
 * 文件名称：Response.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 20:08:09
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:04
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service;

import org.json.JSONObject;

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
public class Response<T> {

    private final String result;

    private Class<T> resultClass;

    public Response(String result) {
        this.result = result;
    }

    public Response(String result, Class<T> resultClass) {
        this.result = result;
        this.resultClass = resultClass;
    }

    public String getResult() {
        return result;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}
