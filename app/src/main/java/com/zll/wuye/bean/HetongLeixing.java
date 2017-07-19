package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/6 14:34
 */
public class HetongLeixing {

    /**
     * body : [{"code":"","id":10001,"name":"合同纠纷","parId":10000},{"code":"","id":10002,"name":"劳务纠纷","parId":10000},{"code":"","id":10003,"name":"物权纠纷","parId":10000},{"code":"","id":10004,"name":"侵权纠纷","parId":10000},{"code":"","id":10005,"name":"其他","parId":10000}]
     * message : 请求成功
     * status : 200
     * timestamp : 1496730668249
     */

    private String message;
    private int status;
    private long timestamp;
    private List<BodyBean> body;

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

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * code :
         * id : 10001
         * name : 合同纠纷
         * parId : 10000
         */

        private String code;
        private int id;
        private String name;
        private int parId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

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

        public int getParId() {
            return parId;
        }

        public void setParId(int parId) {
            this.parId = parId;
        }
    }
}
