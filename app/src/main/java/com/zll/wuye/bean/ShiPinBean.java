package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/7/11 09:27
 */
public class ShiPinBean {

    /**
     * timestamp : 1499736369685
     * message : 请求成功
     * body : {"imgUrl":"","id":9,"isBuyVideo":true,"title":"物业管理法律风险防范必修课","price":0.1,"seeCnt":79,"videoUrl":"http://wuye.kylinlaw.com:8888/wy-mgr/assets/video/1.mp4","creatTm":1498804423000,"cntn":"<p><span style=\"color: rgb(51, 51, 51); font-family: &#39;Helvetica neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 26.04px; background-color: rgb(255, 255, 255);\">物业公司在管理、服务、运营的过程中，稍有不慎就有可能触发法律风险点；在法律纠纷发生后，往往又缺乏专业高效的法律应对措施和指导，导致各类纠纷不断，削弱了物业公司的持续经营能力和盈利能力。为帮助广大物业服务企业提高物业管理法律风险防控和纠纷处理能力，提升经营管理和盈利能力，本课程结合国内典型的行业真实案例设计而成。<\/span><\/p>","type":2}
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
         * imgUrl :
         * id : 9
         * isBuyVideo : true
         * title : 物业管理法律风险防范必修课
         * price : 0.1
         * seeCnt : 79
         * videoUrl : http://wuye.kylinlaw.com:8888/wy-mgr/assets/video/1.mp4
         * creatTm : 1498804423000
         * cntn : <p><span style="color: rgb(51, 51, 51); font-family: &#39;Helvetica neue&#39;, Helvetica, Arial, sans-serif; font-size: 14px; line-height: 26.04px; background-color: rgb(255, 255, 255);">物业公司在管理、服务、运营的过程中，稍有不慎就有可能触发法律风险点；在法律纠纷发生后，往往又缺乏专业高效的法律应对措施和指导，导致各类纠纷不断，削弱了物业公司的持续经营能力和盈利能力。为帮助广大物业服务企业提高物业管理法律风险防控和纠纷处理能力，提升经营管理和盈利能力，本课程结合国内典型的行业真实案例设计而成。</span></p>
         * type : 2
         */

        private String imgUrl;
        private int id;
        private boolean isBuyVideo;
        private String title;
        private double price;
        private int seeCnt;
        private String videoUrl;
        private long creatTm;
        private String cntn;
        private int type;

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

        public int getSeeCnt() {
            return seeCnt;
        }

        public void setSeeCnt(int seeCnt) {
            this.seeCnt = seeCnt;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
