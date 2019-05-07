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
 * 文件名称：Identity.java
 * 文件描述：
 *
 * 创 建 人：ASLai(laijianhua@rratchet.com)
 *
 * 上次修改时间：2019-05-06 23:10:19
 *
 * 修 改 人：ASLai(laijianhua@rratchet.com)
 * 修改时间：2019-05-07 17:18:05
 * 修改备注：
 */

package com.rratchet.support.tencent.youtu.service.api;

/**
 * <pre>
 *
 *      作 者 :        ASLai(laijianhua@rratchet.com).
 *      日 期 :        2019/5/6
 *      版 本 :        V1.0
 *      描 述 :        身份
 *
 *
 * </pre>
 *
 * @param <Response> the type parameter
 * @param <Request>  the type parameter
 * @author ASLai
 */
public interface Identity<Response, Request> {

    /**
     * <h2>个体创建</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/newperson
     *
     * <h3>描述</h3>
     * 创建一个Person，并将Person放置到group_ids指定的组当中
     *
     * <h3>参数</h3>
     * <pre>
     *     	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 必须	group_ids	Array(String)	加入到组的列表
     * 必须	person_id	String	指定的个体id
     * 可选	image	String(Bytes)	base64编码的二进制图片数据
     * 可选	url	String	图片的url，image和url只提供一个就可以了，如果都提供，只使用url
     * 可选	person_name	String	名字
     * 可选	tag	String	备注信息
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	Int	保留字段，目前不使用
     * suc_group	Int	成功被加入的group数量
     * suc_face	Int	成功加入的face数量
     * person_id	String	相应person的id
     * face_id	String	创建所用图片生成的face_id
     * group_ids	Array(String)	加入成功的组id
     * errorcode	Int	返回码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id":"123456",
     *   "person_id":"person7",
     *   "person_name":"johnson",
     *   "image":"ASLFKJAKLSJFLASF",
     *   "group_ids":["tencent"],
     *   "tag":"person tag"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "person_id":"person0",
     *   "suc_group":1,
     *   "suc_face":1,
     *   "errorcode":0,
     *   "session_id":"session_id",
     *   “face_id”:“1009550071676600319”,
     *   "group_ids":["tencent"],
     *   "errormsg":"ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return response response
     * @throws Exception the exception
     */
    Response createPerson(Request request) throws Exception;

    /**
     * <h2>删除个体</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/delperson
     *
     * <h3>描述</h3>
     * 删除一个Person
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 必须	person_id	String	待删除个体ID
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	Int	保留字段，目前不使用
     * person_id	String	成功删除的person_id
     * deleted	Int	成功删除的Person数量
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id":"123456",
     *   "person_id":"person3"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "deleted":1,
     *   "person_id”: “person0”,
     *   "errorcode":0,
     *   "session_id":"session_id",
     *   "errormsg":"ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return the response
     * @throws Exception the exception
     */
    Response deletePerson(Request request) throws Exception;

    /**
     * <h2>增加人脸</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/addface
     *
     * <h3>描述</h3>
     * 将一组Face加入到一个Person中。注意，一个Face只能被加入到一个Person中；一个Person最多允许包含20个Face；一次调用最多加入5个Face；并且加入与库中几乎相同的人脸会返回错误。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 可选	person_id	String	待增加人脸的个体id
     * 可选	images	Array(String)	base64编码的二进制图片数据
     * 可选	urls	Array(String)	图片的urls，images和urls只提供一个就可以了，如果都提供，只使用urls
     * 可选	tag	String	备注信息
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	String	保留字段，目前不使用
     * added	Int	成功加入的face数量
     * face_ids	Array(String)	增加的人脸ID列表
     * ret_codes	Array(Int)	每张图片增加人脸的返回码
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     *      * {
     *      * 	"app_id": "123456",
     *      * 	"person_id": "person0",
     *      * 	"images": ["AASFLJASLJFASFA"],
     *      * 	"tag": "face tag"
     *      * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     * 	"added": 1,
     * 	"face_ids": ["1001331646826348543"],
     * 	"ret_codes": [0],
     * 	"errorcode": 0,
     * 	"session_id": "session_id",
     * 	"errormsg": "ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return response response
     * @throws Exception the exception
     */
    Response addFace(Request request) throws Exception;

    /**
     * <h2>删除人脸</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/delface
     *
     * <h3>描述</h3>
     * 删除一个person下的face，包括特征，属性和face_id。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     *  	person_id	String	待删除人脸的person ID
     *  	face_ids	Array(String)	删除人脸id的列表
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	Int	保留字段，目前不使用
     * deleted	Int	成功删除的face数量
     * face_ids	Array(String)	成功删除的face_id列表
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id":"123456",
     *   "person_id":"person0",
     *   "face_ids":["1006991173632458751"]
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "deleted":1,
     *   "face_ids":["1006991173632458751"],
     *   "errorcode":0,
     *   "session_id":"session_id",
     *   "errormsg":"ok"
     * }
     * </pre>
     * —
     *
     * @param request the request
     * @return response response
     * @throws Exception the exception
     */
    Response deleteFace(Request request) throws Exception;

    /**
     * <h2>设置信息</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/setinfo
     *
     * <h3>描述</h3>
     * 设置Person的name。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 必须	person_id	String	相应person的id
     * 可选	person_name	String	新的name
     * 可选	tag	String	备注信息
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * session_id	Int	保留字段，目前不使用
     * person_id	String	相应person的id
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id":"123456",
     *   "person_id":"person0",
     *   "person_name":"johnson",
     *   "tag":"person tag"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "person_id": "9eb44387923528f97f8545d8bef906db",
     *   "errorcode": 0,
     *   "session_id": "session_id",
     *   "errormsg":"ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return info person info
     * @throws Exception the exception
     */
    Response setPersonInfo(Request request) throws Exception;

    /**
     * <h2>获取信息</h2>
     *
     * <h3>接口</h3>
     * http://api.youtu.qq.com/youtu/api/getinfo
     *
     * <h3>描述</h3>
     * 获取一个Person的信息，包括name，id，tag，相关的face，以及groups等信息。
     *
     * <h3>参数</h3>
     * <pre>
     *  	参数名	类型	参数说明
     * 必须	app_id	String	App的 App ID，请在应用管理中心添加应用后获取
     * 必须	person_id	String	待查询个体的ID
     * </pre>
     *
     * <h3>返回值说明</h3>
     * <pre>
     * 字段	类型	说明
     * person_name	String	相应person的name
     * person_id	String	相应person的id
     * face_ids	Array(String)	包含的人脸列表
     * group_ids	Array(String)	包含此个体的组id
     * tag	String	用户备注信息
     * session_id	String	保留字段，目前不使用
     * errorcode	Int	返回状态码
     * errormsg	String	返回错误消息
     * </pre>
     *
     * <h3>协议</h3>
     * <pre>
     * Request:
     * {
     *   "app_id":"123456",
     *   "person_id":"person0"
     * }
     * </pre>
     *
     * <pre>
     * Response:
     * {
     *   "person_id": "9eb44387923528f97f8545d8bef906db",
     *   "person_name": "NicolasCage",
     *   "face_ids": ["199d1efd19ce4ee67a7ec7655f859b1a", ...],
     *   "group_ids":["tencent", ...],
     *   "tag":"person tag",
     *   "errorcode": 0,
     *   "session_id"："session_id",
     *   "errormsg":"ok"
     * }
     * </pre>
     *
     * @param request the request
     * @return info person info
     * @throws Exception the exception
     */
    Response getPersonInfo(Request request) throws Exception;
}
