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
 * 上次修改时间：2019-05-06 22:24:44
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:04
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service.wrapper.face;

import com.rratchet.support.tencent.youtu.service.AbstractService;
import com.rratchet.support.tencent.youtu.service.RequestOptions;
import com.rratchet.support.tencent.youtu.service.Response;
import com.rratchet.support.tencent.youtu.service.api.Face;

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
public class Service extends AbstractService<Api> implements Face<Response, Params> {

    @Override
    protected Api createApi(String baseUrl) {
        return new Api(baseUrl);
    }

    @Override
    public Response detect(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.detect(options);
            }
        });
    }

    @Override
    public Response shape(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.shape(options);
            }
        });
    }

    @Override
    public Response compare(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.compare(options);
            }
        });
    }

    @Override
    public Response verify(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.verify(options);
            }
        });
    }

    @Override
    public Response multiIdentify(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.multiIdentify(options);
            }
        });
    }

    @Override
    public Response identify(Params params) throws Exception {
        return execute(params, new ExecuteAction<Api, Object>() {
            @Override
            public String execute(Api api, RequestOptions options) throws Exception {
                return api.identify(options);
            }
        });
    }
}
