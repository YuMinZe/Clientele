package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/12 11:02
 */
public class MyGuanzhuBean {


    /**
     * body : [{"address":"北京 东城区 ","cityId":110101,"creatTm":1499067154000,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","id":9,"lawName":"北京中闻律师事务所","lawyerId":6,"name":"张六","period":20,"prvcId":110000,"typeIds":"10003,10004","typeName":"物权纠纷,侵权纠纷"},{"address":"北京 东城区 ","cityId":110101,"creatTm":1499065775000,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","id":2,"lawName":"北京中闻律师事务所","lawyerId":9,"name":"张九","period":12,"prvcId":110000,"typeIds":"10001,10003","typeName":"合同纠纷,物权纠纷"},{"address":"北京 海淀区 ","cityId":110108,"creatTm":1499065771000,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","id":1,"lawName":"北京市炜衡律师事务所","lawyerId":24,"name":"王律师","period":2,"prvcId":110000,"typeIds":"10001,10002","typeName":"合同纠纷,劳动纠纷"}]
     * message : 请求成功
     * status : 200
     * timestamp : 1499067487521
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
         * address : 北京 东城区
         * cityId : 110101
         * creatTm : 1499067154000
         * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png
         * id : 9
         * lawName : 北京中闻律师事务所
         * lawyerId : 6
         * name : 张六
         * period : 20
         * prvcId : 110000
         * typeIds : 10003,10004
         * typeName : 物权纠纷,侵权纠纷
         */

        private String address;
        private int cityId;
        private long creatTm;
        private String headUrl;
        private int id;
        private String lawName;
        private int lawyerId;
        private String name;
        private int period;
        private int prvcId;
        private String typeIds;
        private String typeName;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLawName() {
            return lawName;
        }

        public void setLawName(String lawName) {
            this.lawName = lawName;
        }

        public int getLawyerId() {
            return lawyerId;
        }

        public void setLawyerId(int lawyerId) {
            this.lawyerId = lawyerId;
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

        public int getPrvcId() {
            return prvcId;
        }

        public void setPrvcId(int prvcId) {
            this.prvcId = prvcId;
        }

        public String getTypeIds() {
            return typeIds;
        }

        public void setTypeIds(String typeIds) {
            this.typeIds = typeIds;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }
}
