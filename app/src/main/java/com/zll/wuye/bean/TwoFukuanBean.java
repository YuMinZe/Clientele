package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/27 14:20
 */
public class TwoFukuanBean {


    /**
     * timestamp : 1498544422059
     * message : 请求成功
     * body : {"title":"案件委托第二次付款","orderNo":"WY20170627142022","totalPrice":"123.00"}
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
         * title : 案件委托第二次付款
         * orderNo : WY20170627142022
         * totalPrice : 123.00
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
