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
 * 文件名称：IHumanFaceApi.java
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

package com.rratchet.youtu.api;

import android.graphics.Bitmap;

import java.util.List;

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
public interface IHumanFaceApi {

    /**
     * 人脸检测：检测给定图片(Image)中的所有人脸(Face)的位置和相应的面部属性。
     * 位置包括(x, y, w, h)，
     * 面部属性包括性别(gender),
     * 年龄(age),
     * 表情(expression),
     * 眼镜(glass),
     * 姿态(pitch，roll，yaw).
     *
     * @param image 可选	String(Bytes)	base64编码的二进制图片数据
     * @param url   可选	String          图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * @param mode  可选	Int             检测模式0/1正常/大脸模式
     * @return json object 请求json结果
     * @throws Exception the exception
     */
    @RequestMethod("detectface")
    String detect(String image, String url, int mode) throws Exception;

    /**
     * 五官定位：对请求图片进行五官定位，计算构成人脸轮廓的90个点，
     * 包括眉毛（左右各8点）、
     * 眼睛（左右各8点）、
     * 鼻子（13点）、
     * 嘴巴（22点）、
     * 脸型轮廓（21点）、
     * 眼珠[或瞳孔]（2点）
     *
     * @param image 可选	String(Bytes)	base64编码的二进制图片数据
     * @param url   可选	String          图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * @param mode  可选	Int             检测模式0/1正常/大脸模式
     * @return json object 请求json结果
     * @throws Exception the exception
     */
    @RequestMethod("faceshape")
    String shape(String image, String url, int mode) throws Exception;

    /**
     * 人脸对比：计算两个Face的相似性以及五官相似度。
     *
     * @param imageA 可选	String	使用base64编码的二进制图片数据A
     * @param imageB 可选	String	使用base64编码的二进制图片数据B
     * @param urlA   可选	String	A图片的url，image 和url只提供一个就可以了，如果都提供，只使用url
     * @param urlB   可选	String	B图片的url，image 和url只提供一个就可以了，如果都提供，只使用url
     * @return string string
     * @throws Exception the exception
     */
    @RequestMethod("facecompare")
    String compare(String imageA, String imageB, String urlA, String urlB) throws Exception;

    /**
     * 人脸验证：给定一个Face和一个Person，返回是否是同一个人的判断以及置信度。
     *
     * @param personId 必须	String	        待验证的Person
     * @param image    可选	String(Bytes)	base64编码的二进制图片数据
     * @param url      可选	String	        图片的image 和url只提供一个就可以了,如果都提供,只使用url
     * @return string string
     * @throws Exception the exception
     */
    @RequestMethod("faceverify")
    String verify(String personId, String image, String url) throws Exception;

    /**
     * 人脸检索
     *
     * 二选一	group_id	String	检索的groupid
     * 二选一	group_ids	Array(String)	检索的groupid
     * 可选	topn	Int32	候选人脸数量，一般使用默认值5
     * 可选	min_size	String	人脸检测最小尺寸，一般使用默认值40
     * 可选	image	String(bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的url，image 和url只提供一个，如果都提供，只使用url
     * 可选	session_id	String	Session id
     *
     * @return string string
     * @throws Exception the exception
     */
    @RequestMethod("multifaceidentify")
    String multiIdentify(String group_id, List<String> group_ids, Integer topn, String min_size, String image, String session_id) throws Exception;

    /**
     * 人脸识别
     *
     * @return string string
     * @throws Exception the exception
     */
    @RequestMethod("faceidentify")
    String identify() throws Exception;
}
