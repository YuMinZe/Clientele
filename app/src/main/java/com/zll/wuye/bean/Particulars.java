package com.zll.wuye.bean;

/**
 * 1. 咨询详情问题列表
 * 2. @author $Yuminze
 * 3. @date 2017/5/27 09:14
 */
public class Particulars {

    /**
     * body : {"ansCnt":2,"headImg":"","id":1,"isAdopt":0,"quest":"测试","questFiles":"http://localhost/zd-sys/image/14885258553247297.png,http://localhost/zd-sys/image/14885258553247297.png","questTm":"2017-05-03","seeCnt":5,"selfId":42,"typeId":1,"userId":1,"userName":"15022222222"}
     * message : 请求成功
     * status : 200
     * timestamp : 1495847316555
     */

    private BodyBean body;
    private String message;
    private int status;
    private long timestamp;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class BodyBean {
        /**
         * ansCnt : 2
         * headImg :
         * id : 1
         * isAdopt : 0
         * quest : 测试
         * questFiles : http://localhost/zd-sys/image/14885258553247297.png,http://localhost/zd-sys/image/14885258553247297.png
         * questTm : 2017-05-03
         * seeCnt : 5
         * selfId : 42
         * typeId : 1
         * userId : 1
         * userName : 15022222222
         */

        private int ansCnt;
        private String headImg;
        private int id;
        private int isAdopt;
        private String quest;
        private String questFiles;
        private String questTm;
        private int seeCnt;
        private int selfId;
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

        public String getQuestFiles() {
            return questFiles;
        }

        public void setQuestFiles(String questFiles) {
            this.questFiles = questFiles;
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

        public int getSelfId() {
            return selfId;
        }

        public void setSelfId(int selfId) {
            this.selfId = selfId;
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
