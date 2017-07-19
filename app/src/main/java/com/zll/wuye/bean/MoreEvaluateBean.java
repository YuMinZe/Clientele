package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/1 16:40
 */
public class MoreEvaluateBean {

    /**
     * timestamp : 1496306347746
     * message : 请求成功
     * body : [{"name":"","userId":11,"score":2,"headUrl":"","cntn":"如何在MySQL从多个表中组合字段然后插入到一个新表中，通过一条sql语句实现。具体情形是：有三张表a、b、c，现在需要从表b和表c中分别查几个字段的值插入到表a中对应的字段。对于这种情况，我们可以使用如下的语"},{"name":"张三","userId":1,"score":2,"headUrl":"","cntn":"如何在MySQL从多个表中组合字段然后插入到一个新表中，通过一条sql语句实现。具体情形是：有三张表a、b、c，现在需要从表b和表c中分别查几个字段的值插入到表a中对应的字段。对于这种情况，我们可以使用如下的语"},{"name":"yanan","userId":12,"score":1,"headUrl":"","cntn":"如何在MySQL从多个表中组合字段然后插入到一个新表中，通过一条sql语句实现。具体情形是：有三张表a、b、c，现在需要从表b和表c中分别查几个字段的值插入到表a中对应的字段。对于这种情况，我们可以使用如下的语"},{"name":"张三","userId":1,"score":2,"headUrl":"","cntn":"aaaaaaaaaaaaa"},{"name":"","userId":10,"score":2,"headUrl":"","cntn":"aaaaaaaaaaaaa"},{"name":"张三","userId":1,"score":1,"headUrl":"","cntn":"时的嘎斯的郭德纲的风格的反感的"},{"name":"张三","userId":1,"score":2,"headUrl":"","cntn":"测试"}]
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
         * name :
         * userId : 11
         * score : 2
         * headUrl :
         * cntn : 如何在MySQL从多个表中组合字段然后插入到一个新表中，通过一条sql语句实现。具体情形是：有三张表a、b、c，现在需要从表b和表c中分别查几个字段的值插入到表a中对应的字段。对于这种情况，我们可以使用如下的语
         */

        private String name;
        private int userId;
        private int score;
        private String headUrl;
        private String cntn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
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
    }
}
