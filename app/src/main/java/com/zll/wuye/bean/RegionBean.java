package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 11:27
 */
public class RegionBean {

    /**
     * body : [{"id":330100,"name":"杭州市","parId":330000},{"id":330200,"name":"宁波市","parId":330000},{"id":330300,"name":"温州市","parId":330000},{"id":330400,"name":"嘉兴市","parId":330000},{"id":330500,"name":"湖州市","parId":330000},{"id":330600,"name":"绍兴市","parId":330000},{"id":330700,"name":"金华市","parId":330000},{"id":330800,"name":"衢州市","parId":330000},{"id":330900,"name":"舟山市","parId":330000},{"id":331000,"name":"台州市","parId":330000},{"id":331100,"name":"丽水市","parId":330000}]
     * message : 请求成功
     * status : 200
     * timestamp : 1496287561053
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
         * id : 330100
         * name : 杭州市
         * parId : 330000
         */

        private int id;
        private String name;
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

        public int getParId() {
            return parId;
        }

        public void setParId(int parId) {
            this.parId = parId;
        }
    }
}
