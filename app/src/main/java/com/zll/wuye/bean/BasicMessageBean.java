package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/26 09:44
 */
public class BasicMessageBean {

    /**
     * timestamp : 1498461655937
     * message : 请求成功
     * body : {"fieldIds":"110113","sex":1,"distId":0,"address":"  ","prvcId":0,"cityId":0,"rname":"下雨","ncknm":"44443444","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1520/2017062625209.png","cntn":"","fields":"顺义区"}
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
         * fieldIds : 110113
         * sex : 1
         * distId : 0
         * address :
         * prvcId : 0
         * cityId : 0
         * rname : 下雨
         * ncknm : 44443444
         * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1520/2017062625209.png
         * cntn :
         * fields : 顺义区
         */

        private String fieldIds;
        private int sex;
        private int distId;
        private String address;
        private int prvcId;
        private int cityId;
        private String rname;
        private String ncknm;
        private String headUrl;
        private String cntn;
        private String fields;

        public String getFieldIds() {
            return fieldIds;
        }

        public void setFieldIds(String fieldIds) {
            this.fieldIds = fieldIds;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getDistId() {
            return distId;
        }

        public void setDistId(int distId) {
            this.distId = distId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

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

        public String getRname() {
            return rname;
        }

        public void setRname(String rname) {
            this.rname = rname;
        }

        public String getNcknm() {
            return ncknm;
        }

        public void setNcknm(String ncknm) {
            this.ncknm = ncknm;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public String getCntn() {
            return cntn;
        }

        public void setCntn(String cntn) {
            this.cntn = cntn;
        }

        public String getFields() {
            return fields;
        }

        public void setFields(String fields) {
            this.fields = fields;
        }
    }
}
