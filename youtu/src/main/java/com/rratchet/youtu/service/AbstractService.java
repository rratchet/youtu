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
 * 文件名称：AbstractService.java
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
import com.rratchet.youtu.service.wrapper.face.Params;

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
 * @param <API> the type parameter
 * @author ASLai
 */
public abstract class AbstractService<API extends AbstractApi> {

    /**
     * The M api.
     */
    protected final API mApi;

    /**
     * Instantiates a new Abstract service.
     */
    protected AbstractService() {
        this(false);
    }

    /**
     * Instantiates a new Abstract service.
     *
     * @param enableSecurityAccess the enable security access
     */
    protected AbstractService(boolean enableSecurityAccess) {
        this(enableSecurityAccess ? YouTu.API_VIP_END_POINT : YouTu.API_DEFAULT_SERVICE);
    }

    /**
     * Instantiates a new Abstract service.
     *
     * @param baseUrl the base url
     */
    protected AbstractService(String baseUrl) {
        mApi = createApi(baseUrl);
    }

    /**
     * Execute response.
     *
     * @param <T>    the type parameter
     * @param params the params
     * @param action the action
     * @return the response
     * @throws Exception the exception
     */
    protected final <T> Response<T> execute(AbstractParams params, ExecuteAction<API, T> action) throws Exception {
        RequestOptions options = params.build();
        String result = action.execute(mApi, options);
        if (action.resultClass != null) {
            return new Response<>(result, action.resultClass);
        } else {
            return new Response<>(result);
        }
    }

    /**
     * Create api api.
     *
     * @param baseUrl the base url
     * @return the api
     */
    protected abstract API createApi(String baseUrl);

    /**
     * The type Execute action.
     *
     * @param <T> the type parameter
     */
    protected static abstract class ExecuteAction<API, T> {

        private Class<T> resultClass;

        public ExecuteAction() {
            resultClass = resultClass();
        }

        public Class<T> resultClass() {
            return resultClass;
        }

        /**
         * Execute response.
         *
         * @param api     the api
         * @param options the options
         * @return the response
         * @throws Exception the exception
         */
        public abstract String execute(API api, RequestOptions options) throws Exception;
    }
}
