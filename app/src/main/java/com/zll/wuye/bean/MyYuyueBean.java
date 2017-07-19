package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 15:45
 */
public class MyYuyueBean {


    /**
     * body : [{"creatTm":1497253380000,"isComment":0,"lawyer":{"address":"  ","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","lawName":"中闻所","name":"张三","period":0,"tel":"13911676382","typeName":""},"orderNo":"WY20170612154300","orderStatus":0,"payStatus":1,"totalPrice":0.01,"typeId":1}]
     * message : 请求成功
     * status : 200
     * timestamp : 1497256421364
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
         * creatTm : 1497253380000
         * isComment : 0
         * lawyer : {"address":"  ","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","lawName":"中闻所","name":"张三","period":0,"tel":"13911676382","typeName":""}
         * orderNo : WY20170612154300
         * orderStatus : 0
         * payStatus : 1
         * totalPrice : 0.01
         * typeId : 1
         */

        private long creatTm;
        private int isComment;
        private LawyerBean lawyer;
        private String orderNo;
        private int orderStatus;
        private int payStatus;
        private double totalPrice;
        private int typeId;

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public int getIsComment() {
            return isComment;
        }

        public void setIsComment(int isComment) {
            this.isComment = isComment;
        }

        public LawyerBean getLawyer() {
            return lawyer;
        }

        public void setLawyer(LawyerBean lawyer) {
            this.lawyer = lawyer;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(int payStatus) {
            this.payStatus = payStatus;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public static class LawyerBean {
            /**
             * address :
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png
             * lawName : 中闻所
             * name : 张三
             * period : 0
             * tel : 13911676382
             * typeName :
             */

            private String address;
            private String headUrl;
            private String lawName;
            private String name;
            private int period;
            private String tel;
            private String typeName;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getLawName() {
                return lawName;
            }

            public void setLawName(String lawName) {
                this.lawName = lawName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPeriod() {
                return period;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }
        }
    }
}
