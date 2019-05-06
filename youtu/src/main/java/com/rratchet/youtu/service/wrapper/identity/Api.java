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
 * 上次修改时间：2019-05-06 23:07:22
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-06 23:07:22
 * 修改备注：
 */

package com.rratchet.youtu.service.wrapper.identity;

import com.rratchet.youtu.service.AbstractApi;
import com.rratchet.youtu.service.RequestOptions;
import com.rratchet.youtu.service.api.Identity;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        identity api provider.
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public class Api extends AbstractApi implements Identity<String, RequestOptions> {

    /**
     * Instantiates a new api provider.
     *
     * @param baseUrl the base url
     */
    public Api(String baseUrl) {
        super(baseUrl);
    }

    @Override
    public String createPerson(RequestOptions options) throws Exception {
        String requestMethod = "api/newperson";
        return request(requestMethod, options);
    }

    @Override
    public String deletePerson(RequestOptions options) throws Exception {
        String requestMethod = "api/delperson";
        return request(requestMethod, options);
    }

    @Override
    public String addFace(RequestOptions options) throws Exception {
        String requestMethod = "api/addface";
        return request(requestMethod, options);
    }

    @Override
    public String deleteFace(RequestOptions options) throws Exception {
        String requestMethod = "api/delface";
        return request(requestMethod, options);
    }

    @Override
    public String setPersonInfo(RequestOptions options) throws Exception {
        String requestMethod = "api/setinfo";
        return request(requestMethod, options);
    }

    @Override
    public String getPersonInfo(RequestOptions options) throws Exception {
        String requestMethod = "api/getinfo";
        return request(requestMethod, options);
    }
}
