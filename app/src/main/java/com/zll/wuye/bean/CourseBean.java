package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 10:40
 */
public class CourseBean {


    /**
     * timestamp : 1499136032942
     * message : 请求成功
     * body : [{"id":13,"title":"物业服务企业及物业项目收购兼实战指导","creatTm":1499047679000,"intro":"物业企业及项目收购兼并的必修课"},{"id":12,"title":"业主大会及业主委员会成立政策法规解读及实操指导","creatTm":1499047125000,"intro":"教您怎样成立业主大会和选举产生业主委员会。"},{"id":11,"title":"物业服务企业劳动用工纠纷解决与风险防范","creatTm":1499046592000,"intro":"教物业公司正确处理与员工之间的劳动关系。"},{"id":10,"title":"完美收费：收取，提高物业费及公共收益的必备策略与技巧","creatTm":1499046072000,"intro":"物业公司收取、催缴、提高物业费以及公共收益的必修课。"},{"imgUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170630/1143/2017063090414.jpg","id":8,"title":"实战攻略：提升物业管理法律风险防控与纠纷处理能力的必修课","creatTm":1498794237000,"intro":"全面梳理物业管理法律风险，总结风险防控策略和纠纷处理技巧。"}]
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
         * id : 13
         * title : 物业服务企业及物业项目收购兼实战指导
         * creatTm : 1499047679000
         * intro : 物业企业及项目收购兼并的必修课
         * imgUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170630/1143/2017063090414.jpg
         */

        private int id;
        private String title;
        private long creatTm;
        private String intro;
        private String imgUrl;

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

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
