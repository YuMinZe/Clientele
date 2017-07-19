package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/25 14:51
 */
public class RegisterBean {

    /**
     * body : {"rgstIp":"124.207.59.130","rgstTm":1495693674832,"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNTQ2MTg1NjAwfQ.EgCw_pGHt1LENy3Ksy94a-3Zds7yw7Z7hDqZ6A4BMbuCc6hbX4QEUGyoeiwja8Lfh3mfeJNFSKzrhgBqVZbCGQ","uname":"18310615141"}
     * message : 请求成功
     * status : 200
     * timestamp : 1495693674878
     */

    private BodyBean body;
    private String message;
    private int status;
    private long timestamp;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
         * rgstIp : 124.207.59.130
         * rgstTm : 1495693674832
         * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNTQ2MTg1NjAwfQ.EgCw_pGHt1LENy3Ksy94a-3Zds7yw7Z7hDqZ6A4BMbuCc6hbX4QEUGyoeiwja8Lfh3mfeJNFSKzrhgBqVZbCGQ
         * uname : 18310615141
         */

        private String rgstIp;
        private long rgstTm;
        private String token;
        private String uname;

        public String getRgstIp() {
            return rgstIp;
        }

        public void setRgstIp(String rgstIp) {
            this.rgstIp = rgstIp;
        }

        public long getRgstTm() {
            return rgstTm;
        }

        public void setRgstTm(long rgstTm) {
            this.rgstTm = rgstTm;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }
    }
}
