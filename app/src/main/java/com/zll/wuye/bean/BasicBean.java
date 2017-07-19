package com.zll.wuye.bean;

/**
 * 1. 详情Bean
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 15:14
 */
public class BasicBean {


    /**
     * timestamp : 1499150353710
     * message : 请求成功
     * body : {"lawyer":{"typeName":"合同纠纷,劳动纠纷","sex":1,"distId":null,"cityId":110108,"prvcId":110000,"address":"北京 海淀区 ","name":"王律师","typeIds":"10001,10002","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","cntn":"北京市律师协会会员","period":2,"lawName":"北京市炜衡律师事务所","lawyerNo":"11101201510682627"},"isFlw":true,"lawyerBus":{"actUser":null,"askCnt":0,"likeCnt":2,"isMeet":1,"meetCnt":0,"lawyerId":24,"isAsk":1,"id":24,"seeCnt":0,"caseCnt":2,"commtCnt":0,"income":"0.00","careCnt":0,"meetDur":"0.0","grade":6,"meetPrice":"0.10","askPrice":"0.10"}}
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
         * lawyer : {"typeName":"合同纠纷,劳动纠纷","sex":1,"distId":null,"cityId":110108,"prvcId":110000,"address":"北京 海淀区 ","name":"王律师","typeIds":"10001,10002","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","cntn":"北京市律师协会会员","period":2,"lawName":"北京市炜衡律师事务所","lawyerNo":"11101201510682627"}
         * isFlw : true
         * lawyerBus : {"actUser":null,"askCnt":0,"likeCnt":2,"isMeet":1,"meetCnt":0,"lawyerId":24,"isAsk":1,"id":24,"seeCnt":0,"caseCnt":2,"commtCnt":0,"income":"0.00","careCnt":0,"meetDur":"0.0","grade":6,"meetPrice":"0.10","askPrice":"0.10"}
         */

        private LawyerBean lawyer;
        private boolean isFlw;
        private LawyerBusBean lawyerBus;

        public LawyerBean getLawyer() {
            return lawyer;
        }

        public void setLawyer(LawyerBean lawyer) {
            this.lawyer = lawyer;
        }

        public boolean isIsFlw() {
            return isFlw;
        }

        public void setIsFlw(boolean isFlw) {
            this.isFlw = isFlw;
        }

        public LawyerBusBean getLawyerBus() {
            return lawyerBus;
        }

        public void setLawyerBus(LawyerBusBean lawyerBus) {
            this.lawyerBus = lawyerBus;
        }

        public static class LawyerBean {
            /**
             * typeName : 合同纠纷,劳动纠纷
             * sex : 1
             * distId : null
             * cityId : 110108
             * prvcId : 110000
             * address : 北京 海淀区
             * name : 王律师
             * typeIds : 10001,10002
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png
             * cntn : 北京市律师协会会员
             * period : 2
             * lawName : 北京市炜衡律师事务所
             * lawyerNo : 11101201510682627
             */

            private String typeName;
            private int sex;
            private Object distId;
            private int cityId;
            private int prvcId;
            private String address;
            private String name;
            private String typeIds;
            private String headUrl;
            private String cntn;
            private int period;
            private String lawName;
            private String lawyerNo;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public Object getDistId() {
                return distId;
            }

            public void setDistId(Object distId) {
                this.distId = distId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getPrvcId() {
                return prvcId;
            }

            public void setPrvcId(int prvcId) {
                this.prvcId = prvcId;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTypeIds() {
                return typeIds;
            }

            public void setTypeIds(String typeIds) {
                this.typeIds = typeIds;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getCntn() {
                return cntn;
            }

            public void setCntn(String cntn) {
                this.cntn = cntn;
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

            public String getLawyerNo() {
                return lawyerNo;
            }

            public void setLawyerNo(String lawyerNo) {
                this.lawyerNo = lawyerNo;
            }
        }

        public static class LawyerBusBean {
            /**
             * actUser : null
             * askCnt : 0
             * likeCnt : 2
             * isMeet : 1
             * meetCnt : 0
             * lawyerId : 24
             * isAsk : 1
             * id : 24
             * seeCnt : 0
             * caseCnt : 2
             * commtCnt : 0
             * income : 0.00
             * careCnt : 0
             * meetDur : 0.0
             * grade : 6
             * meetPrice : 0.10
             * askPrice : 0.10
             */

            private Object actUser;
            private int askCnt;
            private int likeCnt;
            private int isMeet;
            private int meetCnt;
            private int lawyerId;
            private int isAsk;
            private int id;
            private int seeCnt;
            private int caseCnt;
            private int commtCnt;
            private String income;
            private int careCnt;
            private String meetDur;
            private int grade;
            private String meetPrice;
            private String askPrice;

            public Object getActUser() {
                return actUser;
            }

            public void setActUser(Object actUser) {
                this.actUser = actUser;
            }

            public int getAskCnt() {
                return askCnt;
            }

            public void setAskCnt(int askCnt) {
                this.askCnt = askCnt;
            }

            public int getLikeCnt() {
                return likeCnt;
            }

            public void setLikeCnt(int likeCnt) {
                this.likeCnt = likeCnt;
            }

            public int getIsMeet() {
                return isMeet;
            }

            public void setIsMeet(int isMeet) {
                this.isMeet = isMeet;
            }

            public int getMeetCnt() {
                return meetCnt;
            }

            public void setMeetCnt(int meetCnt) {
                this.meetCnt = meetCnt;
            }

            public int getLawyerId() {
                return lawyerId;
            }

            public void setLawyerId(int lawyerId) {
                this.lawyerId = lawyerId;
            }

            public int getIsAsk() {
                return isAsk;
            }

            public void setIsAsk(int isAsk) {
                this.isAsk = isAsk;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSeeCnt() {
                return seeCnt;
            }

            public void setSeeCnt(int seeCnt) {
                this.seeCnt = seeCnt;
            }

            public int getCaseCnt() {
                return caseCnt;
            }

            public void setCaseCnt(int caseCnt) {
                this.caseCnt = caseCnt;
            }

            public int getCommtCnt() {
                return commtCnt;
            }

            public void setCommtCnt(int commtCnt) {
                this.commtCnt = commtCnt;
            }

            public String getIncome() {
                return income;
            }

            public void setIncome(String income) {
                this.income = income;
            }

            public int getCareCnt() {
                return careCnt;
            }

            public void setCareCnt(int careCnt) {
                this.careCnt = careCnt;
            }

            public String getMeetDur() {
                return meetDur;
            }

            public void setMeetDur(String meetDur) {
                this.meetDur = meetDur;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public String getMeetPrice() {
                return meetPrice;
            }

            public void setMeetPrice(String meetPrice) {
                this.meetPrice = meetPrice;
            }

            public String getAskPrice() {
                return askPrice;
            }

            public void setAskPrice(String askPrice) {
                this.askPrice = askPrice;
            }
        }
    }
}
