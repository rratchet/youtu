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
 * 文件名称：Params.java
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

import com.rratchet.youtu.service.AbstractParams;

import java.util.List;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        face request params.
 *
 *
 * </pre>
 *
 * @author ASLai
 */
public class Params extends AbstractParams<Params> {

    /**
     * With image data params.
     *
     * @param imageData String(Bytes)    base64编码的二进制图片数据
     * @return the params
     */
    public Params withImageData(String imageData) {
        return put("image", imageData);
    }

    /**
     * With image url params.
     *
     * @param imageUrl 图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * @return the params
     */
    public Params withImageUrl(String imageUrl) {
        return put("url", imageUrl);
    }

    /**
     * 检测模式0/1正常/大脸模式
     *
     * @param mode the mode
     * @return params params
     */
    public Params withMode(int mode) {
        return put("mode", mode);
    }

    /**
     * With image data a params.
     *
     * @param imageData String(Bytes)    base64编码的二进制图片数据
     * @return the params
     */
    public Params withImageDataA(String imageData) {
        return put("imageA", imageData);
    }

    /**
     * With image data b params.
     *
     * @param imageData String(Bytes)    base64编码的二进制图片数据
     * @return the params
     */
    public Params withImageDataB(String imageData) {
        return put("imageB", imageData);
    }

    /**
     * With image url a params.
     *
     * @param imageUrl 图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * @return the params
     */
    public Params withImageUrlA(String imageUrl) {
        return put("urlA", imageUrl);
    }

    /**
     * With image url b params.
     *
     * @param imageUrl 图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * @return the params
     */
    public Params withImageUrlB(String imageUrl) {
        return put("urlB", imageUrl);
    }

    /**
     * With person id params.
     *
     * @param personId the person id
     * @return the params
     */
    public Params withPersonId(String personId) {
        return put("person_id", personId);
    }

    /**
     * With group id params.
     *
     * @param groupId the group id
     * @return the params
     */
    public Params withGroupId(String groupId) {
        return put("group_id", groupId);
    }

    /**
     * With group ids params.
     *
     * @param groupIds the group ids
     * @return the params
     */
    public Params withGroupIds(String... groupIds) {
        return put("group_ids", groupIds);
    }

    /**
     * With top number params.
     *
     * @param topNumber the top number
     * @return the params
     */
    public Params withTopNumber(int topNumber) {
        return put("topn", topNumber);
    }

    /**
     * With min size params.
     *
     * @param minSize the min size
     * @return the params
     */
    public Params withMinSize(String minSize) {
        return put("min_size", minSize);
    }

    /**
     * With session id params.
     *
     * @param sessionId the session id
     * @return the params
     */
    public Params withSessionId(String sessionId) {
        return put("session_id", sessionId);
    }

}
