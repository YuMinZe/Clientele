package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/25 16:14
 */
public class ThreeRegister {

    /**
     * body : {"isLoginCode":false}
     * message : 请求成功
     * status : 200
     * timestamp : 1495699973854
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
         * isLoginCode : false
         */

        private boolean isLoginCode;

        public boolean isIsLoginCode() {
            return isLoginCode;
        }

        public void setIsLoginCode(boolean isLoginCode) {
            this.isLoginCode = isLoginCode;
        }
    }
}
