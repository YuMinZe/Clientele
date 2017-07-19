package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/5 12:55
 */
public class InformationBean {

    /**
     * body : [{"creatTm":1494812583000,"id":1,"imgUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170602/0941/2017060212182.png","intro":"据美国新英格兰有线新闻报道","title":"1"}]
     * message : 请求成功
     * status : 200
     * timestamp : 1496634565153
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
         * creatTm : 1494812583000
         * id : 1
         * imgUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170602/0941/2017060212182.png
         * intro : 据美国新英格兰有线新闻报道
         * title : 1
         */

        private long creatTm;
        private int id;
        private String imgUrl;
        private String intro;
        private String title;

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
