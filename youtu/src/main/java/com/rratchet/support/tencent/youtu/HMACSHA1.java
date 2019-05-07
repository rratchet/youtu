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
 * 文件名称：HMACSHA1.java
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

package com.rratchet.support.tencent.youtu;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

class HMACSHA1 {

	private static final String HMAC_SHA1 = "HmacSHA1";

	public static byte[] getSignature(String data, String key) throws Exception {
		Mac mac = Mac.getInstance(HMAC_SHA1);
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),
				mac.getAlgorithm());
		mac.init(signingKey);

		return mac.doFinal(data.getBytes());
	}
}
