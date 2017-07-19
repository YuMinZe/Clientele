package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/25 16:34
 */
public class SuccessRegister {

    /**
     * body : {"loginIp":"124.207.59.130","loginTm":1495700964818,"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3MCIsImV4cCI6MTU0NjE4NTYwMH0.jDpVzaVfi8w_MmdGApijWtLEjAA7694wdYhSTJS1YA-QcZjEB2JwuIQPn1gD6a0IO1L1Hh9khRFAPqEInfVxzQ","uname":"18310615141"}
     * message : 请求成功
     * status : 200
     * timestamp : 1495700964834
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
         * loginIp : 124.207.59.130
         * loginTm : 1495700964818
         * token : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3MCIsImV4cCI6MTU0NjE4NTYwMH0.jDpVzaVfi8w_MmdGApijWtLEjAA7694wdYhSTJS1YA-QcZjEB2JwuIQPn1gD6a0IO1L1Hh9khRFAPqEInfVxzQ
         * uname : 18310615141
         */

        private String loginIp;
        private long loginTm;
        private String token;
        private String uname;

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public long getLoginTm() {
            return loginTm;
        }

        public void setLoginTm(long loginTm) {
            this.loginTm = loginTm;
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
