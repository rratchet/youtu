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
 * 文件名称：Api.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 20:08:09
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-06 22:23:34
 * 修改备注：
 */

package com.rratchet.youtu.service.wrapper.face;

import com.rratchet.youtu.service.AbstractApi;
import com.rratchet.youtu.service.RequestOptions;
import com.rratchet.youtu.service.api.Face;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        face api provider.
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public class Api extends AbstractApi implements Face<String, RequestOptions> {

    /**
     * Instantiates a new api provider.
     *
     * @param baseUrl the base url
     */
    public Api(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String detect(RequestOptions options) throws Exception {
        String requestMethod = "api/detectface";
        return request(requestMethod, options);
    }

    @Override
    public String shape(RequestOptions options) throws Exception {
        String requestMethod = "api/faceshape";
        return request(requestMethod, options);
    }

    @Override
    public String compare(RequestOptions options) throws Exception {
        String requestMethod = "api/facecompare";
        return request(requestMethod, options);
    }

    @Override
    public String verify(RequestOptions options) throws Exception {
        String requestMethod = "api/faceverify";
        return request(requestMethod, options);
    }

    @Override
    public String multiIdentify(RequestOptions options) throws Exception {
        String requestMethod = "api/multifaceidentify";
        return request(requestMethod, options);
    }

    @Override
    public String identify(RequestOptions options) throws Exception {
        String requestMethod = "api/faceidentify";
        return request(requestMethod, options);
    }
}


