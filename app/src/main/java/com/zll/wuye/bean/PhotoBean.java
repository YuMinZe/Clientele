package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 电话咨询
 * 2. @author $Yuminze
 * 3. @date 2017/5/31 17:07
 */
public class PhotoBean {


    /**
     * timestamp : 1496280402897
     * message : 请求成功
     * body : [{"prvcId":330000,"cityId":330100,"period":20500,"lawName":"浙江星韵律师事务所","id":9,"typeName":"合同纠纷","address":"浙江 杭州市 西湖区","name":"邴朝祥","typeIds":"10001,10026,","distid":330106,"grade":0,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/14592221186901043.png","meetPrice":100},{"typeName":"","id":1,"address":"  ","cityId":0,"prvcId":0,"name":"张三","grade":2,"distid":0,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","period":0,"lawName":"中闻所","meetPrice":11}]
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
         * prvcId : 330000
         * cityId : 330100
         * period : 20500
         * lawName : 浙江星韵律师事务所
         * id : 9
         * typeName : 合同纠纷
         * address : 浙江 杭州市 西湖区
         * name : 邴朝祥
         * typeIds : 10001,10026,
         * distid : 330106
         * grade : 0
         * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/14592221186901043.png
         * meetPrice : 100
         */

        private int prvcId;
        private int cityId;
        private int period;
        private String lawName;
        private int id;
        private String typeName;
        private String address;
        private String name;
        private String typeIds;
        private int distid;
        private int grade;
        private String headUrl;
        private int meetPrice;

        public int getPrvcId() {
            return prvcId;
        }

        public void setPrvcId(int prvcId) {
            this.prvcId = prvcId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public String getLawName() {
            return lawName;
        }

        public void setLawName(String lawName) {
            this.lawName = lawName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTypeIds() {
            return typeIds;
        }

        public void setTypeIds(String typeIds) {
            this.typeIds = typeIds;
        }

        public int getDistid() {
            return distid;
        }

        public void setDistid(int distid) {
            this.distid = distid;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getMeetPrice() {
            return meetPrice;
        }

        public void setMeetPrice(int meetPrice) {
            this.meetPrice = meetPrice;
        }
    }
}
