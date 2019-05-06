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
 * 文件名称：Service.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 23:11:18
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-06 23:11:18
 * 修改备注：
 */

package com.rratchet.youtu.service.wrapper.identity;

import com.rratchet.youtu.service.AbstractService;
import com.rratchet.youtu.service.RequestOptions;
import com.rratchet.youtu.service.Response;
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
public class Service extends AbstractService<Api> implements Identity<Response, Params> {

    @Override
    protected Api createApi(String baseUrl) {
        return new Api(baseUrl);
    }

    @Override
    public Response createPerson(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.createPerson(options);
            }
        });
    }

    @Override
    public Response deletePerson(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.deletePerson(options);
            }
        });
    }

    @Override
    public Response addFace(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.addFace(options);
            }
        });
    }

    @Override
    public Response deleteFace(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.deleteFace(options);
            }
        });
    }

    @Override
    public Response setPersonInfo(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.setPersonInfo(options);
            }
        });
    }

    @Override
    public Response getPersonInfo(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.getPersonInfo(options);
            }
        });
    }
}
