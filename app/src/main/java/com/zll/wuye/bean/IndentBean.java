package com.zll.wuye.bean;

/**
 * 1. 解析 订单
 * 2. @author $Yuminze
 * 3. @date 2017/6/3 10:47
 */
public class IndentBean {

    /**
     * body : {"orderNo":"WY20170603103602","title":"电话咨询律师","totalPrice":"50.00"}
     * message : 请求成功
     * status : 200
     * timestamp : 1496457363003
     */

    private BodyBean body;
    private String message;
    private int status;
    private long timestamp;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class BodyBean {
        /**
         * orderNo : WY20170603103602
         * title : 电话咨询律师
         * totalPrice : 50.00
         */

        private String orderNo;
        private String title;
        private String totalPrice;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}
