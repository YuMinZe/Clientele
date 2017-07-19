package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/6 09:33
 */
public class PhotoBeanfore {

    /**
     * body : [{"fileName":"but_scan_1214.png","path":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170606/0931/2017060639425.png"}]
     * message :
     * status : 200
     * timestamp : 1496712719903
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
         * fileName : but_scan_1214.png
         * path : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170606/0931/2017060639425.png
         */

        private String fileName;
        private String path;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
