package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 15:52
 */
public class VideodanBean {


    /**
     * timestamp : 1499154706682
     * message : 请求成功
     * body : {"title":"物业管理法律风险防范必修课","orderNo":"WY20170704155146","totalPrice":"0.1"}
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
         * title : 物业管理法律风险防范必修课
         * orderNo : WY20170704155146
         * totalPrice : 0.1
         */

        private String title;
        private String orderNo;
        private String totalPrice;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}
