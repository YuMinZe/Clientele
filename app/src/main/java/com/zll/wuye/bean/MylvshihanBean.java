package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 13:38
 */
public class MylvshihanBean {

    /**
     * timestamp : 1498617032492
     * message : 请求成功
     * body : [{"id":216,"title":"律师函","orderNo":"WY20170626160748","payStatus":1,"creatTm":1498464468000,"cntn":"他聚聚吧","orderStatus":0,"totalPrice":0.1},{"id":215,"title":"律师函","orderNo":"WY20170626160631","payStatus":0,"creatTm":1498464391000,"cntn":"啥玩意","orderStatus":0,"totalPrice":50}]
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
         * id : 216
         * title : 律师函
         * orderNo : WY20170626160748
         * payStatus : 1
         * creatTm : 1498464468000
         * cntn : 他聚聚吧
         * orderStatus : 0
         * totalPrice : 0.1
         */

        private int id;
        private String title;
        private String orderNo;
        private int payStatus;
        private long creatTm;
        private String cntn;
        private int orderStatus;
        private double totalPrice;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public int getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(int payStatus) {
            this.payStatus = payStatus;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getCntn() {
            return cntn;
        }

        public void setCntn(String cntn) {
            this.cntn = cntn;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}
