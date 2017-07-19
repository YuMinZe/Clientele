package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 09:22
 */
public class AnliLeixing {

    /**
     * timestamp : 1497576110548
     * message : 请求成功
     * body : [{"id":10001,"name":"合同纠纷","code":"","parId":10000},{"id":10002,"name":"劳务纠纷","code":"","parId":10000},{"id":10003,"name":"物权纠纷","code":"","parId":10000},{"id":10004,"name":"侵权纠纷","code":"","parId":10000},{"id":10005,"name":"其他","code":"","parId":10000}]
     * status : 200
     */

    private long timestamp;
    private String message;
    private int status;
    private List<BodyBean> body;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * id : 10001
         * name : 合同纠纷
         * code :
         * parId : 10000
         */

        private int id;
        private String name;
        private String code;
        private int parId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getParId() {
            return parId;
        }

        public void setParId(int parId) {
            this.parId = parId;
        }
    }
}
