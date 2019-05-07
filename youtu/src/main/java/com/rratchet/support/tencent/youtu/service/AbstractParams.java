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
 * 文件名称：AbstractParams.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 22:57:18
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:05
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        abstract params.
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public abstract class AbstractParams<Params extends AbstractParams> {

    /**
     * The Options.
     */
    private final RequestOptions options;

    /**
     * Instantiates a new Params.
     */
    public AbstractParams() {
        options = new RequestOptions();
    }

    public RequestOptions build() {
        return options;
    }

    /**
     * Put options params.
     *
     * @param key   the key
     * @param value the value
     * @return the params
     */
    protected final Params put(String key, Object value) {
        options.put(key, value);
        return (Params) this;
    }
}
