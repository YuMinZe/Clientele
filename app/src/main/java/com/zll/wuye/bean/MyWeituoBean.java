package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 13:25
 */
public class MyWeituoBean {

    /**
     * timestamp : 1496899450211
     * message : 请求成功
     * body : [{"status":0,"offerStrt":111,"id":12,"typeName":"物权纠纷","address":"河北 秦皇岛市 ","offerEnd":222,"userId":70,"creatTm":1496899079000,"cntn":"123123123213","user":{"name":"xiaoyu","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170607/1135/2017060730579.png"}}]
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
         * status : 0
         * offerStrt : 111.0
         * id : 12
         * typeName : 物权纠纷
         * address : 河北 秦皇岛市
         * offerEnd : 222.0
         * userId : 70
         * creatTm : 1496899079000
         * cntn : 123123123213
         * user : {"name":"xiaoyu","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170607/1135/2017060730579.png"}
         */

        private int status;
        private double offerStrt;
        private int id;
        private String typeName;
        private String address;
        private double offerEnd;
        private int userId;
        private long creatTm;
        private String cntn;
        private UserBean user;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getOfferStrt() {
            return offerStrt;
        }

        public void setOfferStrt(double offerStrt) {
            this.offerStrt = offerStrt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public double getOfferEnd() {
            return offerEnd;
        }

        public void setOfferEnd(double offerEnd) {
            this.offerEnd = offerEnd;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * name : xiaoyu
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170607/1135/2017060730579.png
             */

            private String name;
            private String headUrl;

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
        }
    }
}
