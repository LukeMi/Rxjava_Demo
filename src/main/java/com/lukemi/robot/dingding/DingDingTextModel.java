package com.lukemi.robot.dingding;

import java.util.List;

public class DingDingTextModel {

    /**
     * msgtype : text
     * text : {"content":"我就是我, 是不一样的烟火@156xxxx8827"}
     * at : {"atMobiles":["156xxxx8827","189xxxx8325"],"isAtAll":false}
     */

    public String msgtype;
    public TextBean text;
    public AtBean at;

    public static class TextBean {
        public String content;
    }

    public static class AtBean {
        public boolean isAtAll;
        public List<String> atMobiles;

    }
}
