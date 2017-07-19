package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/21 15:02
 */
public class MyZiXuBean {


    /**
     * timestamp : 1498615571212
     * message : 请求成功
     * body : [{"isComment":0,"id":234,"title":"电话咨询律师","orderNo":"WY20170627171152","payStatus":0,"creatTm":1498554712000,"cntn":"123456","lawyer":{"typeName":"劳动纠纷,侵权纠纷","address":"北京 石景山区","tel":"18399999999","name":"666666","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1549/2017062634525.jpg","period":18,"lawName":"中路"},"typeId":19,"orderStatus":0,"totalPrice":0.01},{"isComment":1,"id":223,"title":"电话咨询律师","orderNo":"WY20170627113217","payStatus":1,"creatTm":1498534337000,"cntn":"123456","lawyer":{"typeName":"劳动纠纷,侵权纠纷","address":"北京 石景山区","tel":"18399999999","name":"666666","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1549/2017062634525.jpg","period":18,"lawName":"中路"},"typeId":19,"orderStatus":1,"totalPrice":0.1},{"isComment":0,"id":213,"title":"电话咨询律师","orderNo":"WY20170626160037","payStatus":1,"creatTm":1498464037000,"cntn":"123456","lawyer":{"typeName":"劳动纠纷,侵权纠纷","address":"北京 石景山区","tel":"18399999999","name":"666666","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1549/2017062634525.jpg","period":18,"lawName":"中路"},"typeId":19,"orderStatus":1,"totalPrice":0.1}]
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
         * id : 234
         * title : 电话咨询律师
         * orderNo : WY20170627171152
         * payStatus : 0
         * creatTm : 1498554712000
         * cntn : 123456
         * lawyer : {"typeName":"劳动纠纷,侵权纠纷","address":"北京 石景山区","tel":"18399999999","name":"666666","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1549/2017062634525.jpg","period":18,"lawName":"中路"}
         * typeId : 19
         * orderStatus : 0
         * totalPrice : 0.01
         */

        private int isComment;
        private int id;
        private String title;
        private String orderNo;
        private int payStatus;
        private long creatTm;
        private String cntn;
        private LawyerBean lawyer;
        private int typeId;
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

        public LawyerBean getLawyer() {
            return lawyer;
        }

        public void setLawyer(LawyerBean lawyer) {
            this.lawyer = lawyer;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
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

        public static class LawyerBean {
            /**
             * typeName : 劳动纠纷,侵权纠纷
             * address : 北京 石景山区
             * tel : 18399999999
             * name : 666666
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1549/2017062634525.jpg
             * period : 18
             * lawName : 中路
             */

            private String typeName;
            private String address;
            private String tel;
            private String name;
            private String headUrl;
            private int period;
            private String lawName;

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

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
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
        }
    }
}
