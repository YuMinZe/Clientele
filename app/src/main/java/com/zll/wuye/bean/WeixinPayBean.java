package com.zll.wuye.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/7 15:09
 */
public class WeixinPayBean {

    /**
     * body : {"appid":"wx221bc5c1e6f8865a","flag":"true","noncestr":"izq5UNFaqtVD","package":"Sign=WXPay","partnerid":"1480234622","prepayid":"wx201706071505503e007e4b580876961022","sign":"D13AAF54F975C43E583D786D8C3A95C4","timestamp":"1496819150"}
     * status : 200
     * timestamp : 1496819150252
     */

    private BodyBean body;
    private int status;
    private long timestamp;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class BodyBean {
        /**
         * appid : wx221bc5c1e6f8865a
         * flag : true
         * noncestr : izq5UNFaqtVD
         * package : Sign=WXPay
         * partnerid : 1480234622
         * prepayid : wx201706071505503e007e4b580876961022
         * sign : D13AAF54F975C43E583D786D8C3A95C4
         * timestamp : 1496819150
         */

        private String appid;
        private String flag;
        private String noncestr;
        @SerializedName("package")
        private String packageX;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String timestamp;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
