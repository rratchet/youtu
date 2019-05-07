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
 * 上次修改时间：2019-05-06 23:06:34
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:05
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service.wrapper.identity;

import com.rratchet.support.tencent.youtu.service.AbstractParams;

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
public class Params extends AbstractParams<Params> {

    public Params withGroupIds(String... groupIds) {
        return put("group_ids", groupIds);
    }

    public Params withPersonId(String personId) {
        return put("person_id", personId);
    }

    public Params withPersonName(String personName) {
        return put("person_name", personName);
    }

    public Params withImageData(String imageData) {
        return put("image", imageData);
    }

    public Params withImageUrl(String imageUrl) {
        return put("url", imageUrl);
    }

    public Params withTag(String tag) {
        return put("tag", tag);
    }

    public Params withImageDataArray(String... imageDataArray) {
        return put("images", imageDataArray);
    }

    public Params withImageUrlArray(String... imageUrlArray) {
        return put("urls", imageUrlArray);
    }

    public Params withFaceIds(String... faceIds) {
        return put("face_ids", faceIds);
    }

}
