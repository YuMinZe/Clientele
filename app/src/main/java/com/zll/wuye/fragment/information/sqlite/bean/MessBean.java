package com.zll.wuye.fragment.information.sqlite.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 14:18
 */
public class MessBean {

    private String cntn;
    private String listid;
    private String type;
    private String time;
    private String read;

    public MessBean(String cntn, String listid, String type, String time, String read) {
        this.cntn = cntn;
        this.listid = listid;
        this.type = type;
        this.time = time;
        this.read = read;
    }

    public String getCntn() {
        return cntn;
    }

    public void setCntn(String cntn) {
        this.cntn = cntn;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
