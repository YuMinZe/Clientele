package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 订单Bean
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 10:19
 */
public class Dingdan {

    /**
     * timestamp : 1498464929274
     * message : 请求成功
     * body : [{"isComment":0,"id":218,"title":"预约律师","orderNo":"WY20170626161026","payStatus":1,"payWay":1,"attr":"{\"tel\":\"5383868383\",\"name\":\"噢噢噢\",\"cntn\":\"特头女虐\"}","creatTm":1498464626000,"type":"mentLawyer","orderStatus":0,"totalPrice":0.1},{"isComment":0,"id":217,"title":"物业催收","orderNo":"WY20170626160829","payStatus":0,"payWay":0,"attr":"{\"tel\":\"12225559663\",\"name\":\"用吗\",\"cntn\":\"你以为我\",\"type\":1}","creatTm":1498464509000,"type":"property","orderStatus":0,"totalPrice":50},{"isComment":0,"id":216,"title":"律师函","orderNo":"WY20170626160748","payStatus":1,"payWay":1,"attr":"{\"tel\":\"123456789\",\"name\":\"123456799\",\"cntn\":\"他聚聚吧\"}","creatTm":1498464468000,"type":"letter","orderStatus":0,"totalPrice":0.1},{"isComment":0,"id":215,"title":"律师函","orderNo":"WY20170626160631","payStatus":0,"payWay":0,"attr":"{\"tel\":\"123456789\",\"name\":\"123\",\"cntn\":\"啥玩意\"}","creatTm":1498464391000,"type":"letter","orderStatus":0,"totalPrice":50},{"isComment":0,"id":214,"title":"案件委托","orderNo":"WY20170626160558","payStatus":1,"payWay":1,"attr":"{\"distId\":0,\"cityId\":\"130200\",\"prvcId\":\"130000\",\"caseStatus\":1,\"earnest\":100,\"tel\":\"123456789\",\"type\":0,\"offerstrt\":\"1000\",\"title\":\"哈哈哈\",\"fileUrls\":\"\",\"offerEnd\":\"2000\",\"name\":\"小于\",\"cntn\":\"HK咯噢噢噢\",\"typeId\":10003}","creatTm":1498464358000,"type":"case","orderStatus":0,"totalPrice":0.1},{"isComment":0,"id":213,"title":"电话咨询律师","orderNo":"WY20170626160037","payStatus":1,"payWay":1,"attr":"{\"tel\":\"123456789\",\"name\":\"小于\",\"cntn\":\"123456\"}","creatTm":1498464037000,"type":"askLawyer","orderStatus":1,"totalPrice":0.1}]
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
         * isComment : 0
         * id : 218
         * title : 预约律师
         * orderNo : WY20170626161026
         * payStatus : 1
         * payWay : 1
         * attr : {"tel":"5383868383","name":"噢噢噢","cntn":"特头女虐"}
         * creatTm : 1498464626000
         * type : mentLawyer
         * orderStatus : 0
         * totalPrice : 0.1
         */

        private int isComment;
        private int id;
        private String title;
        private String orderNo;
        private int payStatus;
        private int payWay;
        private String attr;
        private long creatTm;
        private String type;
        private int orderStatus;
        private double totalPrice;

        public int getIsComment() {
            return isComment;
        }

        public void setIsComment(int isComment) {
            this.isComment = isComment;
        }

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

        public int getPayWay() {
            return payWay;
        }

        public void setPayWay(int payWay) {
            this.payWay = payWay;
        }

        public String getAttr() {
            return attr;
        }

        public void setAttr(String attr) {
            this.attr = attr;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
