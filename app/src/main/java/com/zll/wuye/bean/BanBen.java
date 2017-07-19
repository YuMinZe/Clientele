package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/11 14:50
 */
public class BanBen {


    /**
     * timestamp : 1499755794822
     * message : 请求成功
     * body : {"path":"http://wuye.kylinlaw.com/assets/apk/wylv.apk","v":"1.0"}
     * status : 200
     */

    private long timestamp;
    private String message;
    private BodyBean body;
    private int status;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public static class BodyBean {
        /**
         * path : http://wuye.kylinlaw.com/assets/apk/wylv.apk
         * v : 1.0
         */

        private String path;
        private String v;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }
}
