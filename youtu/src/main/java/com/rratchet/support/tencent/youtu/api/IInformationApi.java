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
 * 文件名称：IInformationApi.java
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

package com.rratchet.support.tencent.youtu.api;

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
public interface IInformationApi {

    /**
     * 获取组列表
     *
     * @return
     */
    @RequestMethod("getgroupids")
    String getGroupIds() throws Exception;

    /**
     * 获取人列表
     *
     * @return
     */
    @RequestMethod("getpersonids")
    String getPersonIds() throws Exception;

    /**
     * 获取人脸列表
     *
     * @return
     */
    @RequestMethod("getfaceids")
    String getFaceIds() throws Exception;

    /**
     * 获取人脸信息
     *
     * @return
     */
    @RequestMethod("getfaceinfo")
    String getFaceInfo() throws Exception;
}
