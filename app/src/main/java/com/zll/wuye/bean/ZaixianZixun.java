package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/5/26 16:02
 */
public class ZaixianZixun {

    /**
     * body : [{"ansCnt":0,"headImg":"","id":15,"isAdopt":0,"quest":"哈哈哈","questTm":"2017-05-14","seeCnt":5,"typeId":0,"userId":1,"userName":"15022222222"},{"ansCnt":0,"headImg":"","id":14,"isAdopt":0,"quest":"哈哈哈GG","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":1,"userName":"15022222222"},{"ansCnt":0,"headImg":"","id":13,"isAdopt":0,"quest":"哈哈哈GG","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":42,"userName":"15112345678"},{"ansCnt":0,"headImg":"","id":12,"isAdopt":0,"quest":"哈哈哈GG","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":42,"userName":"15112345678"},{"ansCnt":0,"headImg":"","id":11,"isAdopt":0,"quest":"哈哈哈GG","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":42,"userName":"15112345678"},{"ansCnt":0,"headImg":"","id":10,"isAdopt":0,"quest":"哈哈哈哈好","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":42,"userName":"15112345678"},{"ansCnt":0,"headImg":"","id":9,"isAdopt":0,"quest":"哈哈哈哈","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":1,"userName":"15022222222"},{"ansCnt":0,"headImg":"","id":8,"isAdopt":0,"quest":"哈哈哈哈","questTm":"2017-05-14","seeCnt":0,"typeId":0,"userId":42,"userName":"15112345678"},{"ansCnt":0,"headImg":"","id":5,"isAdopt":0,"quest":"哈哈哈哈","questTm":"2017-05-09","seeCnt":15,"typeId":1,"userId":1,"userName":"15022222222"},{"ansCnt":0,"headImg":"","id":4,"isAdopt":0,"quest":"哈哈哈哈","questTm":"2017-05-08","seeCnt":3,"typeId":1,"userId":1,"userName":"15022222222"}]
     * message : 请求成功
     * status : 200
     * timestamp : 1495785603495
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
         * ansCnt : 0
         * headImg :
         * id : 15
         * isAdopt : 0
         * quest : 哈哈哈
         * questTm : 2017-05-14
         * seeCnt : 5
         * typeId : 0
         * userId : 1
         * userName : 15022222222
         */

        private int ansCnt;
        private String headImg;
        private int id;
        private int isAdopt;
        private String quest;
        private String questTm;
        private int seeCnt;
        private int typeId;
        private int userId;
        private String userName;

        public int getAnsCnt() {
            return ansCnt;
        }

        public void setAnsCnt(int ansCnt) {
            this.ansCnt = ansCnt;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public String getQuestTm() {
            return questTm;
        }

        public void setQuestTm(String questTm) {
            this.questTm = questTm;
        }

        public int getSeeCnt() {
            return seeCnt;
        }

        public void setSeeCnt(int seeCnt) {
            this.seeCnt = seeCnt;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
