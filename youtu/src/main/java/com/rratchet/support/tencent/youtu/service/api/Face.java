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
 * 文件名称：Face.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 22:08:15
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:04
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service.api;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        人脸
 *
 *
 * </pre>
 *
 * @param <Response> the type parameter
 * @param <Request>  the type parameter
 * @author ASLai
 */
public interface Face<Response, Request> {

    /**
     *
     * <h2>人脸检测</h2>
     * <h3>接口</h4>
     *     http://api.youtu.qq.com/youtu/api/detectface
     * <h3>描述</h3>
     *     检测给定图片(Image)中的所有人脸(Face)的位置和相应的面部属性。位置包括(x, y, w, h)，面部属性包括性别(gender)，年龄(age)，表情(expression)，魅力(beauty)，眼镜(glasses)和姿态(pitch, roll, yaw)，至多返回5个人脸的属性。
     * <h3>参数</h3>
     * <pre>
     *          参数名	类型          参数说明
     * 必须	app_id	String	        App的App ID，请在应用管理中心添加应用后获取
     * 可选	image	String(Bytes)	base64编码的二进制图片数据
     * 可选	url     String          图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * 可选	mode    Int             检测模式0/1正常/大脸模式
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段               类型             说明
     * session_id        String	         保留字段，目前不使用
     * image_width       Int	         请求图片的宽度
     * image_height      Int	         请求图片的高度
     * face              Array(FaceItem) 被检测出的人脸FaceItem的列表
     * errorcode         Int             返回状态值
     * errormsg          String          返回错误消
     * </pre>
     *
     * <h4>FaceItem说明</h4>
     * <pre>
     * 字段	类型	说明
     * x	Point	人脸框左上角x
     * y	Point	人脸框左上角y
     * width	Float	人脸框宽度
     * height	Float	人脸框高度
     * gender	Int	性别[0/(female)~100(male)]
     * age	Int	年龄[0~100]
     * expression	Int	微笑[0(normal)~50(smile)~100(laugh)]
     * beauty	Int	魅力[0~100]
     * glasses	Int	眼镜[0不戴眼镜 1戴眼镜 2戴墨镜] 注：替代原glass（Bool）字段
     * pitch	Int	上下偏移[-30,30]
     * yaw	Int	左右偏移[-30,30]
     * roll	Int	平面旋转[-180,180]
     * face_shape	Array(FaceShapeItem)	人脸配准坐标（参考人脸配准faceshape接口）
     * </pre>
     *
     * <h4>FaceShapeItem说明</h4>
     * <pre>
     * 字段	类型	说明
     * face_profile	Array(Point)	描述脸型轮廓的21点
     * left_eye	Array(Point)	描述左眼轮廓的8点
     * right_eye	Array(Point)	描述右眼轮廓的8点
     * left_eyebrow	Array(Point)	描述左眉轮廓的8点
     * right_eyebrow	Array(Point)	描述右眉轮廓的8点
     * mouth	Array(Point)	描述嘴巴轮廓的22点
     * nose	Array(Point)	描述鼻子轮廓的13点
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id": "123456",
     *   "image": "asdfasdfasdf12312"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "session_id": "",
     *   "image_height": 120,
     *   "image_width": 120,
     *   "face":[{
     *     "x": 29,
     *     "y": 39,
     *     "height": 66.0,
     *     "width": 66.0,
     *     "pitch": 16,
     *     "roll": -1,
     *     "yaw": 3,
     *     "age": 27,
     *     "gender": 0,
     *     "glass": false,
     *     "expression": 31,
     *     "glasses": 0,
     *     "mask": 0,
     *     "hat": 0,
     *     "beauty": 92,
     *     "face_shape":{
     *       "face_profile": [{"x":32,"y":59}, {"x":33,"y":65}, {"x":34,"y":71}, {"x":35,"y":77}, {"x":37,"y":83}, {"x":39,"y":88},{"x":42,"y":93}, {"x":46,"y":97}, {"x":51,"y":101}, {"x":56,"y":104}, {"x":62,"y":105}, {"x":68,"y":104}, {"x":73,"y":101}, {"x":77,"y":96}, {"x":81,"y":92}, {"x":84,"y":87}, {"x":86,"y":82}, {"x":87,"y":76}, {"x":88,"y":70}, {"x":89,"y":64}, {"x":89,"y":59}],
     *       "left_eye": [{"x":42,"y":59}, {"x":45,"y":60}, {"x":48,"y":61}, {"x":51,"y":61}, {"x":53,"y":61}, {"x":51,"y":58}, {"x":48,"y":57}, {"x":45,"y":57}],
     *       "right_eye": [{"x":80,"y":59},{"x":78,"y":61},{"x":75,"y":61},{"x":72,"y":61},{"x":70,"y":61},{"x":71,"y":58},{"x":74,"y":57},{"x":78,"y":57}],
     *       "left_eyebrow": [{"x":37,"y":52},{"x":42,"y":52},{"x":47,"y":52},{"x":51,"y":53},{"x":56,"y":54},{"x":52,"y":51},{"x":47,"y":49},{"x":42,"y":49}],
     *       "right_eyebrow": [{"x":84,"y":52},{"x":80,"y":52},{"x":76,"y":53},{"x":72,"y":54},{"x":68,"y":54},{"x":71,"y":51},{"x":76,"y":50},{"x":80,"y":50}],
     *       "mouth": [{"x":51,"y":87},{"x":54,"y":90},{"x":58,"y":92},{"x":62,"y":93},{"x":66,"y":92},{"x":70,"y":90},{"x":72,"y":86},{"x":68,"y":86},{"x":64,"y":85},{"x":62,"y":86},{"x":59,"y":85},{"x":55,"y":86},{"x":54,"y":88},{"x":58,"y":89},{"x":62,"y":89},{"x":65,"y":89},{"x":69,"y":88},{"x":69,"y":87},{"x":65,"y":88},{"x":62,"y":88},{"x":58,"y":88},{"x":55,"y":87}],
     *       "nose": [{"x":62,"y":77},{"x":61,"y":61},{"x":60,"y":65},{"x":58,"y":69},{"x":56,"y":74},{"x":54,"y":78},{"x":58,"y":80},{"x":62,"y":81},{"x":66,"y":80},{"x":69,"y":78},{"x":67,"y":73},{"x":65,"y":69},{"x":63,"y":65}]}}
     *     ],
     *   "errorcode": 0,
     *   "errormsg": "OK"
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response detect(Request request) throws Exception;

    /**
     * <h2>人脸检测与分析</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/faceshape
     *
     * <h3>描述</h3>
     * 对请求图片进行五官定位，计算构成人脸轮廓的90个点，包括眉毛（左右各8点）、眼睛（左右各8点）、鼻子（13点）、嘴巴（22点）、脸型轮廓（21点）、眼珠[或瞳孔]（2点）
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的App ID，请在应用管理中心添加应用后获取
     * 可选	image	String(Bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * 可选	mode	Int	检测模式 0 正常（默认）/ 1 大脸模式
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	String	保留字段，目前不使用
     * face_shape	Array(FaceShapeItem)	人脸轮廓结构体，包含所有人脸的轮廓点
     * face_profile	Array(Point)	描述脸型轮廓的21点
     * left_eye	Array(Point)	描述左眼轮廓的8点
     * right_eye	Array(Point)	描述右眼轮廓的8点
     * left_eyebrow	Array(Point)	描述左眉轮廓的8点
     * right_eyebrow	Array(Point)	描述右眉轮廓的8点
     * mouth	Array(Point)	描述嘴巴轮廓的22点
     * nose	Array(Point)	描述鼻子轮廓的13点
     * image_width	Int	请求图片的宽度
     * image_height	Int	请求图片的高度
     * errorcode	Int	返回状态值
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     * 	"app_id": "123456",
     * 	"image": "asdfasdfasdf12312",
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "session_id": "",
     *   "face_shape": [{
     *     "face_profile":[{"x":32,"y":59},{"x":33,"y":65},{"x":34,"y":71},{"x":35,"y":77},{"x":37,"y":83},{"x":39,"y":88},{"x":42,"y":93},{"x":46,"y":97},{"x":51,"y":101},{"x":56,"y":104},{"x":62,"y":105},{"x":68,"y":104},{"x":73,"y":101},{"x":77,"y":96},{"x":81,"y":92},{"x":84,"y":87},{"x":86,"y":82},{"x":87,"y":76},{"x":88,"y":70},{"x":89,"y":64},{"x":89,"y":59}],
     *     "left_eye":[{"x":42,"y":59},{"x":45,"y":60},{"x":48,"y":61},{"x":51,"y":61},{"x":53,"y":61},{"x":51,"y":58},{"x":48,"y":57},{"x":45,"y":57}],
     *     "right_eye":[{"x":80,"y":59},{"x":78,"y":61},{"x":75,"y":61},{"x":72,"y":61},{"x":70,"y":61},{"x":71,"y":58},{"x":74,"y":57},{"x":78,"y":57}],
     *     "left_eyebrow":[{"x":37,"y":52},{"x":42,"y":52},{"x":47,"y":52},{"x":51,"y":53},{"x":56,"y":54},{"x":52,"y":51},{"x":47,"y":49},{"x":42,"y":49}],
     *     "right_eyebrow":[{"x":84,"y":52},{"x":80,"y":52},{"x":76,"y":53},{"x":72,"y":54},{"x":68,"y":54},{"x":71,"y":51},{"x":76,"y":50},{"x":80,"y":50}],
     *     "mouth":[{"x":51,"y":87},{"x":54,"y":90},{"x":58,"y":92},{"x":62,"y":93},{"x":66,"y":92},{"x":70,"y":90},{"x":72,"y":86},{"x":68,"y":86},{"x":64,"y":85},{"x":62,"y":86},{"x":59,"y":85},{"x":55,"y":86},{"x":54,"y":88},{"x":58,"y":89},{"x":62,"y":89},{"x":65,"y":89},{"x":69,"y":88},{"x":69,"y":87},{"x":65,"y":88},{"x":62,"y":88},{"x":58,"y":88},{"x":55,"y":87}],
     *     "nose":[{"x":62,"y":77},{"x":61,"y":61},{"x":60,"y":65},{"x":58,"y":69},{"x":56,"y":74},{"x":54,"y":78},{"x":58,"y":80},{"x":62,"y":81},{"x":66,"y":80},{"x":69,"y":78},{"x":67,"y":73},{"x":65,"y":69},{"x":63,"y":65}]
     *   }],
     *   "image_height":120,
     *   "image_width":120,
     *   "errorcode":0,
     *   "errormsg":"OK"
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response shape(Request request) throws Exception;

    /**
     * <h2>人脸识别</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/facecompare
     *
     * <h3>描述</h3>
     * 计算两个Face的相似性以及五官相似度。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 可选	imageA	String	使用base64编码的二进制图片数据A
     * 可选	imageB	String	使用base64编码的二进制图片数据B
     * 可选	urlA	String	A图片的url，image 和url只提供一个就可以了，如果都提供，只使用url
     * 可选	urlB	String	B图片的url，image 和url只提供一个就可以了，如果都提供，只使用url
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response compare(Request request) throws Exception;

    /**
     * <h2>人脸验证</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/faceverify
     *
     * <h3>描述</h3>
     * 给定一个Face和一个Person，返回是否是同一个人的判断以及置信度。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID, 请在应用管理中心添加应用后获取
     * 必须	person_id	String	待验证的Person
     * 可选	image	String(Bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的image 和url只提供一个就可以了,如果都提供,只使用url
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * ismatch	Bool	两个输入是否为同一人的判断
     * confidence	Float	系统对这个判断的置信度
     * session_id	String	保留字段，目前不使用
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     * 	"app_id": "123456",
     * 	"person_id": "person0",
     * 	"image": "ASLDGJKALSJDKG"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     * 	"confidence": 50.502410888671878,
     * 	"ismatch": false,
     * 	"session_id": "xxxx",
     * 	"errorcode": 0,
     * 	"errormsg": "ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response verify(Request request) throws Exception;

    /**
     * <h2>人脸检索</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/multifaceidentify
     *
     * <h3>描述</h3>
     * 上传人脸图片，进行人脸检索。
     *
     * <h3>参数</h3>
     * <pre>
     *     	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 二选一	group_id	String	检索的groupid
     * 二选一	group_ids	Array(String)	检索的groupid
     * 可选	topn	Int32	候选人脸数量，一般使用默认值5
     * 可选	min_size	String	人脸检测最小尺寸，一般使用默认值40
     * 可选	image	String(bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的url，image 和url只提供一个，如果都提供，只使用url
     * 可选	session_id	String	Session id
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * errorcode	Int32	返回码
     * errormsg	String	返回错误消息
     * results	Array	识别结果
     * group_size	Int32	group_id包含的人脸个数
     * time_ms	Int32	耗时
     * session_id	String	对应Session id
     * </pre>
     *
     * <h4>MultiIdentifyItem结构体</h4>
     * <pre>
     * 字段	类型	说明
     * candidates	IdentifyItem	识别结果
     * face_rect	FaceRectItem	人脸框位置
     * </pre>
     *
     * <h4>IdentifyItem说明</h4>
     * <pre>
     * 字段	类型	说明
     * person_id	Int32	候选者的个体id
     * faceid	String	候选者的人脸id
     * confidence	float	候选者的置信度
     * tag	String	人脸备注信息
     * </pre>
     *
     * <h4>FaceRectItem说明</h4>
     * <pre>
     * 字段	类型	说明
     * x	Int32	人脸位置左上角横坐标
     * y	Int32	人脸位置左上角纵坐标
     * width	Int32	人脸宽度
     * height	Int32	人脸高度
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id": "123456",
     *   "group_id": "tencent",
     *   "image": "ASDKFALKDJFA"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "session_id": "383",
     *   "results": [{
     *     "candidates": [{
     *       "person_id": "p1",
     *       "face_id": "0001",
     *       "confidence": 63,
     *       "tag": ""
     *     }, {
     *       "person_id": "p2",
     *       "face_id": "00002",
     *       "confidence": 35,
     *       "tag": ""
     *     }],
     *     "face_rect": {
     *       "x": 100,
     *       "y": 100,
     *       "width": 200,
     *       "height": 200
     *     }
     *   }],
     *   "errorcode": 0,
     *   "erromsg": "OK",
     *   "group_size": 1000,
     *   "time_ms": 687
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response multiIdentify(Request request) throws  Exception;

    /**
     * <h2>人脸识别</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/faceidentify
     *
     * <h3>描述</h3>
     * 对于一个待识别的人脸图片，在一个Group中识别出最相似的Top5 Person作为其身份返回，返回的Top5中按照相似度从大到小排列。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID, 请在应用管理中心添加应用后获取
     * 必须	group_id	String	候选人组id
     * 可选	image	String(Bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的image 和url只提供一个就可以了,如果都提供,只使用url
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	String	保留字段，目前不使用
     * candidates	Array(IdentifyItem)	识别出的top5候选人
     * group_size	Int	本次识别请求检索的库总大小
     * time_ms	Int	识别耗时
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h4>IdentifyItem说明</h4>
     * <pre>
     * 字段	类型	说明
     * person_id	String	候选者person_id
     * face_id	String	候选者face_id
     * confidence	Float	候选者的置信度
     * tag	String	人脸备注信息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     * 	"app_id": "123456",
     * 	"person_id": "person0",
     * 	"image": "ASLDGJKALSJDKG"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     * 	"session_id": "session_id",
     * 	"candidates": [{
     * 		"person_id": "person3",
     * 		"face_id": "1031567119985213439",
     * 		"confidence": 54.90695571899414,
     * 		“tag”: “new tag”
     *        }, {
     * 		"person_id": "person1",
     * 		"face_id": "1031587105968553983",
     * 		"confidence": 54.86775207519531,
     * 		“tag”: “new tag”
     *    }],
     * 	"errorcode": 0,
     * 	"errormsg": "OK"
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response identify(Request request) throws Exception;
}
