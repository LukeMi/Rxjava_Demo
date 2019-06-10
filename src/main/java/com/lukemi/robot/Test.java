package com.lukemi.robot;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Test {
    String qrImage = "https://www.pgyer.com/app/qrcodeHistory/6d4a7bcb015d360a307e16301d9a01f06b7c77d28883eaf6f6cd2849e499ed5e";
    String link = "https://www.pgyer.com/h7AF";


    public static void main(String[] args) {
        String json = "{\n" +
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
        PGYUploadResponse pgyUploadResponse = JSON.parseObject(json, PGYUploadResponse.class);
        dingDingRobot(pgyUploadResponse.data);
    }

    /**
     * 钉钉机器人(注意必须使用自定义机器人)
     */
    private static void dingDingRobot(PGYUploadResponse.DataBean data) {
        ContentModel contentModel = new ContentModel();
        contentModel.text = "已经上传至蒲公英,可以下载使用了" + data.buildCreated;
        contentModel.title = "上传提醒" + data.buildVersion;
        contentModel.picUrl = data.buildQRCodeURL;
        contentModel.messageUrl = "https://www.pgyer.com/" + data.buildShortcutUrl;

        System.out.println("sendMsgToDing");
        try {
            String path = "https://oapi.dingtalk.com/robot/send?access_token=f7101297d61bfa23b6e1b0ff14c86b0035fce7780d47698b02b64fbb6d00e2bf";
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
            HashMap<String, Object> map = new HashMap<>();
            map.put("msgtype", "link");
            map.put("link", contentModel);
            String json = JSON.toJSONString(map);
            dos.write(json.getBytes("utf-8"));
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
            System.out.println("发送到钉钉群执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
