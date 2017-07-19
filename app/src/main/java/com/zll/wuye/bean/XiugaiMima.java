package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/26 14:22
 */
public class XiugaiMima {

    /**
     * timestamp : 1495779684424
     * message : 请求成功
     * body : {"fieldIds":"","rname":"12356","ncknm":"18310615141","sex":1,"headUrl":"","cntn":"","fields":""}
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
         * fieldIds :
         * rname : 12356
         * ncknm : 18310615141
         * sex : 1
         * headUrl :
         * cntn :
         * fields :
         */

        private String fieldIds;
        private String rname;
        private String ncknm;
        private int sex;
        private String headUrl;
        private String cntn;
        private String fields;

        public String getFieldIds() {
            return fieldIds;
        }

        public void setFieldIds(String fieldIds) {
            this.fieldIds = fieldIds;
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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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
