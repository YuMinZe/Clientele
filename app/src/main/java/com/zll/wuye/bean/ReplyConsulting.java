package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 回复咨询
 * 2. @author $Yuminze
 * 3. @date 2017/5/31 09:15
 */
public class ReplyConsulting {

    /**
     * timestamp : 1498631899224
     * message : 请求成功
     * body : [{"id":21,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170620/1601/2017062089022.jpg","isAdopt":1,"userId":11,"userName":"15888888888","ansTm":"2017-06-22","replyLawyerId":10,"askId":17,"ans":"Juju","ansFiles":null},{"id":20,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170620/1601/2017062089022.jpg","isAdopt":0,"userId":11,"userName":"15888888888","ansTm":"2017-06-22","replyLawyerId":10,"askId":17,"ans":"Hhhhkk","ansFiles":null},{"id":19,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170620/1601/2017062089022.jpg","isAdopt":1,"userId":11,"userName":"15888888888","ansTm":"2017-06-22","replyLawyerId":10,"askId":17,"ans":"Hhhhkk","ansFiles":null}]
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
         * id : 21
         * headImg : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170620/1601/2017062089022.jpg
         * isAdopt : 1
         * userId : 11
         * userName : 15888888888
         * ansTm : 2017-06-22
         * replyLawyerId : 10
         * askId : 17
         * ans : Juju
         * ansFiles : null
         */

        private int id;
        private String headImg;
        private int isAdopt;
        private int userId;
        private String userName;
        private String ansTm;
        private int replyLawyerId;
        private int askId;
        private String ans;
        private Object ansFiles;

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

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
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

        public String getAnsTm() {
            return ansTm;
        }

        public void setAnsTm(String ansTm) {
            this.ansTm = ansTm;
        }

        public int getReplyLawyerId() {
            return replyLawyerId;
        }

        public void setReplyLawyerId(int replyLawyerId) {
            this.replyLawyerId = replyLawyerId;
        }

        public int getAskId() {
            return askId;
        }

        public void setAskId(int askId) {
            this.askId = askId;
        }

        public String getAns() {
            return ans;
        }

        public void setAns(String ans) {
            this.ans = ans;
        }

        public Object getAnsFiles() {
            return ansFiles;
        }

        public void setAnsFiles(Object ansFiles) {
            this.ansFiles = ansFiles;
        }
    }
}
