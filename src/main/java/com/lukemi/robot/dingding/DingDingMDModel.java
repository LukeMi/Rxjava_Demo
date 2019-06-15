package com.lukemi.robot.dingding;

import java.util.List;

public class DingDingMDModel {

    /**
     * msgtype : markdown
     * markdown : {"title":"杭州天气","text":"#### 杭州天气 @156xxxx8827\n> 9度，西北风1级，空气良89，相对温度73%\n\n > ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)\n > ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n"}
     * at : {"atMobiles":["156xxxx8827","189xxxx8325"],"isAtAll":false}
     */

    public String msgtype;
    public MarkdownBean markdown;
    public AtBean at;

    public static class MarkdownBean {
        /**
         * title : 杭州天气
         * text : #### 杭州天气 @156xxxx8827
         > 9度，西北风1级，空气良89，相对温度73%

         > ![screenshot](https://gw.alipayobjects.com/zos/skylark-tools/public/files/84111bbeba74743d2771ed4f062d1f25.png)
         > ###### 10点20分发布 [天气](http://www.thinkpage.cn/)

         */

        public String title;
        public String text;
    }

    public static class AtBean {
        /**
         * atMobiles : ["156xxxx8827","189xxxx8325"]
         * isAtAll : false
         */

        public boolean isAtAll;
        public List<String> atMobiles;

    }
}
