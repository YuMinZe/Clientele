package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/28 13:39
 */
public class KeFuBean {

    /**
     * timestamp : 1498628360336
     * message :
     * body : {"casePrice":0.1,"letterPrice":0.1,"tel":"10086"}
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
         * casePrice : 0.1
         * letterPrice : 0.1
         * tel : 10086
         */

        private double casePrice;
        private double letterPrice;
        private String tel;

        public double getCasePrice() {
            return casePrice;
        }

        public void setCasePrice(double casePrice) {
            this.casePrice = casePrice;
        }

        public double getLetterPrice() {
            return letterPrice;
        }

        public void setLetterPrice(double letterPrice) {
            this.letterPrice = letterPrice;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
