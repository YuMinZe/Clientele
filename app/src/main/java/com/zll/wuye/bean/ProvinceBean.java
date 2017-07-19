package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 10:24
 */
public class ProvinceBean {

    /**
     * body : [{"id":110000,"name":"北京","parId":100000},{"id":120000,"name":"天津","parId":100000},{"id":130000,"name":"河北","parId":100000},{"id":140000,"name":"山西","parId":100000},{"id":150000,"name":"内蒙古","parId":100000},{"id":210000,"name":"辽宁","parId":100000},{"id":220000,"name":"吉林","parId":100000},{"id":230000,"name":"黑龙江","parId":100000},{"id":310000,"name":"上海","parId":100000},{"id":320000,"name":"江苏","parId":100000},{"id":330000,"name":"浙江","parId":100000},{"id":340000,"name":"安徽","parId":100000},{"id":350000,"name":"福建","parId":100000},{"id":360000,"name":"江西","parId":100000},{"id":370000,"name":"山东","parId":100000},{"id":410000,"name":"河南","parId":100000},{"id":420000,"name":"湖北","parId":100000},{"id":430000,"name":"湖南","parId":100000},{"id":440000,"name":"广东","parId":100000},{"id":450000,"name":"广西","parId":100000},{"id":460000,"name":"海南","parId":100000},{"id":500000,"name":"重庆","parId":100000},{"id":510000,"name":"四川","parId":100000},{"id":520000,"name":"贵州","parId":100000},{"id":530000,"name":"云南","parId":100000},{"id":540000,"name":"西藏","parId":100000},{"id":610000,"name":"陕西","parId":100000},{"id":620000,"name":"甘肃","parId":100000},{"id":630000,"name":"青海","parId":100000},{"id":640000,"name":"宁夏","parId":100000},{"id":650000,"name":"新疆","parId":100000},{"id":710000,"name":"台湾","parId":100000},{"id":810000,"name":"香港","parId":100000},{"id":820000,"name":"澳门","parId":100000}]
     * message : 请求成功
     * status : 200
     * timestamp : 1496283692635
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
         * id : 110000
         * name : 北京
         * parId : 100000
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
