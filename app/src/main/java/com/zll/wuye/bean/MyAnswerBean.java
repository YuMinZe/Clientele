package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/20 11:02
 */
public class MyAnswerBean {


    /**
     * timestamp : 1499058753285
     * message : 请求成功
     * body : [{"isAdopt":0,"ansCnt":0,"questTm":"2017-07-03","selfId":null,"questFiles":null,"quest":"哈哈哈","id":2,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170703/1311/2017070326118.png","seeCnt":0,"userId":46,"userName":"鱼","ansTm":null,"typeId":10001}]
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
         * isAdopt : 0
         * ansCnt : 0
         * questTm : 2017-07-03
         * selfId : null
         * questFiles : null
         * quest : 哈哈哈
         * id : 2
         * headImg : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170703/1311/2017070326118.png
         * seeCnt : 0
         * userId : 46
         * userName : 鱼
         * ansTm : null
         * typeId : 10001
         */

        private int isAdopt;
        private int ansCnt;
        private String questTm;
        private Object selfId;
        private Object questFiles;
        private String quest;
        private int id;
        private String headImg;
        private int seeCnt;
        private int userId;
        private String userName;
        private Object ansTm;
        private int typeId;

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
        }

        public int getAnsCnt() {
            return ansCnt;
        }

        public void setAnsCnt(int ansCnt) {
            this.ansCnt = ansCnt;
        }

        public String getQuestTm() {
            return questTm;
        }

        public void setQuestTm(String questTm) {
            this.questTm = questTm;
        }

        public Object getSelfId() {
            return selfId;
        }

        public void setSelfId(Object selfId) {
            this.selfId = selfId;
        }

        public Object getQuestFiles() {
            return questFiles;
        }

        public void setQuestFiles(Object questFiles) {
            this.questFiles = questFiles;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getSeeCnt() {
            return seeCnt;
        }

        public void setSeeCnt(int seeCnt) {
            this.seeCnt = seeCnt;
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

        public Object getAnsTm() {
            return ansTm;
        }

        public void setAnsTm(Object ansTm) {
            this.ansTm = ansTm;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }
    }
}
