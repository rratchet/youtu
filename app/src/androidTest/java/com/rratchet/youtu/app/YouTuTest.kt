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
 * 模块名称：app
 *
 * 文件名称：YouTuTest.kt
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

package com.rratchet.youtu.app

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.rratchet.youtu.YouTu
import com.rratchet.youtu.service.wrapper.face.Params
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

/**
 * <pre>
 *
 * 作 者 :        ASLai(laijianhua@rratchet.com).
 * 日 期 :        2019/5/6
 * 版 本 :        V1.0
 * 描 述 :        description
 *
 *
</pre> *
 *
 * @author ASLai
 */
@RunWith(AndroidJUnit4::class)
class YouTuTest {

    internal var nofaceurl = "http://avatar.csdn.net/7/7/A/1_lewsn2008.jpg";
    internal var onefaceurl = "http://img1.gtimg.com/ent/pics/hv1/189/25/952/61910364.jpg"
    internal var multifaceurl = "http://photos.imageevent.com/sipphoto/samplepictures/large/Cousins%20FE%20crop.jpg"
    internal var multifaceurl2 = "http://n.sinaimg.cn/transform/20150424/Q1vL-cczmvup0266165.jpg"
    internal var notpicurl = "http://www.cnblogs.com/end/archive/2012/02/21/2360965.html"
    internal var wrongurl = "http://img1.gtimg.com/ent/pics/hv1/189/25kgewkpewmnh952/61910364.jpg"
    internal var oneface2url = "http://i0.sinaimg.cn/IT/2011/1215/U5384P2DT20111215041107.png"

    @Before
    fun initYouTu() {
        val context = InstrumentationRegistry.getTargetContext()
        YouTu.initSDK(context)
    }

    @Test
    fun face_detect() {

        val face = YouTu.getInstance().face()
        val params = Params()
        params.withImageUrl(onefaceurl)
        try {
            val response = face.detect(params)
            println(response.result)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}