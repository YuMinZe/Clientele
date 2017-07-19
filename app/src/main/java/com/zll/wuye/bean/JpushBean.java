package com.zll.wuye.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/30 11:11
 */
public class JpushBean {


    /**
     * cntn : 尊敬的律师，您好！感谢您对我们产品的支持，在您与用户的沟通过程中，请不要留下您的手机号与微信号等联系方式或引导用户留下个人联系方式，如有该等行为将禁止登陆平台账号，感谢您的配合支持。
     * param : {"id":"1"}
     * type : sys
     */

    private String cntn;
    private ParamBean param;
    private String type;

    public String getCntn() {
        return cntn;
    }

    public void setCntn(String cntn) {
        this.cntn = cntn;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class ParamBean {
        /**
         * id : 1
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
