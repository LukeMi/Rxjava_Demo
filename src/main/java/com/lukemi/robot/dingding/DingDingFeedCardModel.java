package com.lukemi.robot.dingding;

import java.util.List;

public class DingDingFeedCardModel {

    /**
     * feedCard : {"links":[{"title":"时代的火车向前开","messageURL":"https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI","picURL":"https://www.dingtalk.com/"},{"title":"时代的火车向前开2","messageURL":"https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI","picURL":"https://www.dingtalk.com/"}]}
     * msgtype : feedCard
     */

    public FeedCardBean feedCard;
    public String msgtype;

    public static class FeedCardBean {
        public List<LinksBean> links;

        public static class LinksBean {
            public String title;
            public String messageURL;
            public String picURL;
        }
    }
}
