package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/4 14:53
 */
public class VideoBean {


    /**
     * timestamp : 1499150864800
     * message : 请求成功
     * body : [{"imgUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170630/1433/2017063018858.jpg","id":9,"isBuyVideo":false,"title":"物业管理法律风险防范必修课","price":0.1,"creatTm":1498804423000,"intro":"物业管理面临的法律风险识别及防控策略与方法。"}]
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
         * imgUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/cms/20170630/1433/2017063018858.jpg
         * id : 9
         * isBuyVideo : false
         * title : 物业管理法律风险防范必修课
         * price : 0.1
         * creatTm : 1498804423000
         * intro : 物业管理面临的法律风险识别及防控策略与方法。
         */

        private String imgUrl;
        private int id;
        private boolean isBuyVideo;
        private String title;
        private double price;
        private long creatTm;
        private String intro;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIsBuyVideo() {
            return isBuyVideo;
        }

        public void setIsBuyVideo(boolean isBuyVideo) {
            this.isBuyVideo = isBuyVideo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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
    }
}
