package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/4 13:54
 */
public class PaymentBean {

    /**
     * body : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017050507120934&biz_content=%7B%22body%22%3A%22%E7%94%B5%E8%AF%9D%E5%92%A8%E8%AF%A2%E5%BE%8B%E5%B8%88%22%2C%22out_trade_no%22%3A%22WY20170604134632%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E7%94%B5%E8%AF%9D%E5%92%A8%E8%AF%A2%E5%BE%8B%E5%B8%88%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%2250.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fwww.kylinlaw.com%3A8080%2Fwy-api%2Falipay%2Fnotify&sign=GRsvkPzd4S%2FYtp6V3BhDxavIgTNcbFf9BmiJ4eh3ODVzRzGQqbsLnmt2HVjBp5CUNIyo0BqmEjdoeZmIYeT%2FThaXUv7kqFr7C3bOCVayfnMwvnQz3HVyq%2FmS1eK24m5J3S1Xs8EzGqzLLYsjgisL%2FcxEDLFbPaHFck%2Fi3A0qaOawSr8YsdVCRCJ555oNHZpc89P1zBccqspKb%2FpTqyMR8NYSyKf1yOTsbzHQhR4mJ6Yc6W6XuKp8WwvmL36rJRJm4oXdQ9QBn6cERzgjPvyVF%2BL97A1uNQ%2FvUZOnjGGOi0wwmpEXI3rBhwV3078ZKZnZJqAAwGHN2DqwnxUns8%2BwKg%3D%3D&sign_type=RSA2&timestamp=2017-06-04+13%3A46%3A37&version=1.0
     * message : 请求成功
     * status : 200
     * timestamp : 1496555197476
     */

    private String body;
    private String message;
    private int status;
    private long timestamp;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
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
}
