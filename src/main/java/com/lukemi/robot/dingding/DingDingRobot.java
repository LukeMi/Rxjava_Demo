package com.lukemi.robot.dingding;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lukemi
 * @date 2019/6/18 10:22
 * @des 钉钉机器人
 * @link https://open-doc.dingtalk.com/microapp/serverapi2/qf2nxq
 * @mail chenmingzhiji@163.com
 **/
public class DingDingRobot {
    static String path = "https://oapi.dingtalk.com/robot/send?access_token=f7101297d61bfa23b6e1b0ff14c86b0035fce7780d47698b02b64fbb6d00e2bf";

    public static void main(String[] args) {

//        dingDingRobot();

//        sendText();

//        markdown();

//        actionCard();

        actionCardDependence();

//        feedCard();
    }

    /**
     * 钉钉机器人(注意必须使用自定义机器人)
     */
    private static void dingDingRobot() {
        String pgy = "{\n" +
                "    \"code\": 0,\n" +
                "    \"message\": \"\",\n" +
                "    \"data\": {\n" +
                "        \"buildKey\": \"d043212063017a6d19c7a37dbf46d186\",\n" +
                "        \"buildType\": \"2\",\n" +
                "        \"buildIsFirst\": \"0\",\n" +
                "        \"buildIsLastest\": \"1\",\n" +
                "        \"buildFileKey\": \"cf5805b3b7504a7f59af3002eae1a258.apk\",\n" +
                "        \"buildFileName\": \"app-yinyongbao-release_v1.0.apk\",\n" +
                "        \"buildFileSize\": \"124206575\",\n" +
                "        \"buildName\": \"Tbug\",\n" +
                "        \"buildVersion\": \"1.0\",\n" +
                "        \"buildVersionNo\": \"1\",\n" +
                "        \"buildBuildVersion\": \"15\",\n" +
                "        \"buildIdentifier\": \"com.lukemi.android.tutorial\",\n" +
                "        \"buildIcon\": \"22bc3ad9517acfe01b762711c4cf326f\",\n" +
                "        \"buildDescription\": \"\",\n" +
                "        \"buildUpdateDescription\": \"test\",\n" +
                "        \"buildScreenshots\": \"\",\n" +
                "        \"buildShortcutUrl\": \"h7AF\",\n" +
                "        \"buildCreated\": \"2019-06-10 13:45:48\",\n" +
                "        \"buildUpdated\": \"2019-06-10 13:45:48\",\n" +
                "        \"buildQRCodeURL\": \"https://www.pgyer.com/app/qrcodeHistory/6d4a7bcb015d360a307e16301d9a01f06b7c77d28883eaf6f6cd2849e499ed5e\"\n" +
                "    }\n" +
                "}";
        PGYUploadResponse pgyUploadResponse = JSON.parseObject(pgy, PGYUploadResponse.class);
        PGYUploadResponse.DataBean data = pgyUploadResponse.data;

        DingDingLinkModel contentModel = new DingDingLinkModel();
        contentModel.text = "已经上传至蒲公英,可以下载使用了" + data.buildCreated;
        contentModel.title = "上传提醒" + data.buildVersion;
        contentModel.picUrl = data.buildQRCodeURL;
        contentModel.messageUrl = "https://www.pgyer.com/" + data.buildShortcutUrl;
        System.out.println("sendMsgToDing");


        HashMap<String, Object> map = new HashMap<>();
        map.put("msgtype", "link");
        map.put("link", contentModel);
        String json = JSON.toJSONString(map);
        send(json);

    }

    private static void sendText() {
        DingDingTextModel model = new DingDingTextModel();
        model.msgtype = "text";

        DingDingTextModel.TextBean textBean = new DingDingTextModel.TextBean();
        textBean.content = "新华社头条";

        DingDingTextModel.AtBean atBean = new DingDingTextModel.AtBean();
        atBean.isAtAll = false;
        ArrayList<String> strings = new ArrayList<>();
        strings.add("15195980364");

        atBean.atMobiles = strings;
        model.at = atBean;
        model.text = textBean;

        send(JSON.toJSONString(model));
    }

    private static void send(String msg) {
        System.out.println(msg);
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.write(msg.getBytes("utf-8"));
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while ((line = input.readLine()) != null) {
                result += line;
            }
            dos.flush();
            dos.close();
            input.close();
            conn.connect();
            System.out.println(result);
            JSONObject jsonObject = JSON.parseObject(result);
            System.out.println("发送到钉钉群执行结束 ： " + (jsonObject.getIntValue("errcode") != 0 ? "失败" : "成功"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * markdown 类型消息
     */
    private static void markdown() {
        String md = "{\n" +
                "    \"msgtype\": \"markdown\",\n" +
                "    \"markdown\": {\n" +
                "        \"title\": \"杭州天气\",\n" +
                "        \"text\": \"#### 杭州天气 @17681820100 \\n> 9度，西北风1级，空气良89，相对温度73%\\n\\n > ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\\n > ###### 10点20分发布 [天气](http://www.baidu.cn/) \\n\"\n" +
                "    },\n" +
                "    \"at\": {" +
                "        \"atMobiles\": [" +
                "            \"17681820100\"," +
                "            \"15195980364\"" +
                "        ],\n" +
                "        \"isAtAll\": false\n" +
                "    }\n" +
                "}";
        DingDingMDModel model = JSON.parseObject(md, DingDingMDModel.class);
        send(JSON.toJSONString(model));
    }

    /**
     * actionCard 类型
     */
    private static void actionCard() {
        String str = "{\n" +
                "    \"actionCard\": {\n" +
                "        \"title\": \"乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身\", \n" +
                "        \"text\": \"![screenshot](serverapi2/@lADOpwk3K80C0M0FoA) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划\", \n" +
                "        \"hideAvatar\": \"0\", \n" +
                "        \"btnOrientation\": \"0\", \n" +
                "        \"singleTitle\" : \"阅读全文\",\n" +
                "        \"singleURL\" : \"https://www.dingtalk.com/\"\n" +
                "    }, \n" +
                "    \"msgtype\": \"actionCard\"\n" +
                "}";
        DingDingActionCardModel model = JSON.parseObject(str, DingDingActionCardModel.class);
        send(JSON.toJSONString(model));
    }

    private static void actionCardDependence() {
        String str = "{\n" +
                "    \"actionCard\": {\n" +
                "        \"title\": \"乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身\", \n" +
                "        \"text\": \"![screenshot](https://www.baidu.com/img/baidu_jgylogo3.gif) \n" +
                " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划\", \n" +
                "        \"hideAvatar\": \"0\", \n" +
                "        \"btnOrientation\": \"0\", \n" +
                "        \"btns\": [\n" +
                "            {\n" +
                "                \"title\": \"头条官网\", \n" +
                "                \"actionURL\": \"https://toutiao.com/\"\n" +
                "            }, \n" +
                "            {\n" +
                "                \"title\": \"腾讯新闻\", \n" +
                "                \"actionURL\": \"https://www.qq.com/\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }, \n" +
                "    \"msgtype\": \"actionCard\"\n" +
                "}";
        send(str);
    }

    /**
     * FeedCard 类型
     */
    private static void feedCard() {
        String str = "{\n" +
                "    \"feedCard\": {\n" +
                "        \"links\": [\n" +
                "            {\n" +
                "                \"title\": \"时代的火车向前开\", \n" +
                "                \"messageURL\": \"https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI\", \n" +
                "                \"picURL\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2920084749,2018893236&fm=58&s=39C718720E8EBE011B398BAC0300F024&bpow=121&bpoh=75\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"title\": \"时代的火车向前开2\", \n" +
                "                \"messageURL\": \"https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI\", \n" +
                "                \"picURL\": \"https://www.dingtalk.com/\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }, \n" +
                "    \"msgtype\": \"feedCard\"\n" +
                "}";
        DingDingFeedCardModel model = JSON.parseObject(str, DingDingFeedCardModel.class);
        send(JSON.toJSONString(model));
    }
}
