package com.lukemi.robot;

/**
 * 调用蒲公英机器人
 */
public class PGYUploadResponse {

    /**
     * code : 0
     * message :
     * data : {"buildKey":"d043212063017a6d19c7a37dbf46d186","buildType":"2","buildIsFirst":"0","buildIsLastest":"1","buildFileKey":"cf5805b3b7504a7f59af3002eae1a258.apk","buildFileName":"app-yinyongbao-release_v1.0.apk","buildFileSize":"124206575","buildName":"Tbug","buildVersion":"1.0","buildVersionNo":"1","buildBuildVersion":"15","buildIdentifier":"com.lukemi.android.tutorial","buildIcon":"22bc3ad9517acfe01b762711c4cf326f","buildDescription":"","buildUpdateDescription":"test","buildScreenshots":"","buildShortcutUrl":"h7AF","buildCreated":"2019-06-10 13:45:48","buildUpdated":"2019-06-10 13:45:48","buildQRCodeURL":"https://www.pgyer.com/app/qrcodeHistory/6d4a7bcb015d360a307e16301d9a01f06b7c77d28883eaf6f6cd2849e499ed5e"}
     */

    public int code;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * buildKey : d043212063017a6d19c7a37dbf46d186
         * buildType : 2
         * buildIsFirst : 0
         * buildIsLastest : 1
         * buildFileKey : cf5805b3b7504a7f59af3002eae1a258.apk
         * buildFileName : app-yinyongbao-release_v1.0.apk
         * buildFileSize : 124206575
         * buildName : Tbug
         * buildVersion : 1.0
         * buildVersionNo : 1
         * buildBuildVersion : 15
         * buildIdentifier : com.lukemi.android.tutorial
         * buildIcon : 22bc3ad9517acfe01b762711c4cf326f
         * buildDescription :
         * buildUpdateDescription : test
         * buildScreenshots :
         * buildShortcutUrl : h7AF
         * buildCreated : 2019-06-10 13:45:48
         * buildUpdated : 2019-06-10 13:45:48
         * buildQRCodeURL : https://www.pgyer.com/app/qrcodeHistory/6d4a7bcb015d360a307e16301d9a01f06b7c77d28883eaf6f6cd2849e499ed5e
         */

        public String buildKey;
        public String buildType;
        public String buildIsFirst;
        public String buildIsLastest;
        public String buildFileKey;
        public String buildFileName;
        public String buildFileSize;
        public String buildName;
        public String buildVersion;
        public String buildVersionNo;
        public String buildBuildVersion;
        public String buildIdentifier;
        public String buildIcon;
        public String buildDescription;
        public String buildUpdateDescription;
        public String buildScreenshots;
        public String buildShortcutUrl;
        public String buildCreated;
        public String buildUpdated;
        public String buildQRCodeURL;
    }
}
