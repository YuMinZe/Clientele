package com.zll.wuye.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/8 14:38
 */
public class MyWeiTuoxqBean {

    /**
     * timestamp : 1500267873858
     * message : 请求成功
     * body : {"status":4,"tel":"18655264436","earnest":0.1,"markCnt":1,"list":[{"id":10,"price":0.2,"status":1,"userId":53,"isMark":0,"cntn":"gfxfj","lawyer":{"typeName":"合同纠纷,劳动纠纷,侵权纠纷","address":"北京 海淀区","name":"王占强律师","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170710/0954/2017071050626.jpg","period":2,"lawName":"北京市炜衡律师事务所","lawyerNo":"11101201510682627"}}],"offerStrt":0,"typeName":"合同纠纷","id":14,"fileUrls":"","title":"jj","address":"天津 河西区 ","offerEnd":1,"userId":63,"name":"nfjjfkd","markUserId":53,"creatTm":1500170521000,"cntn":"dhhdhd"}
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
         * status : 4
         * tel : 18655264436
         * earnest : 0.1
         * markCnt : 1
         * list : [{"id":10,"price":0.2,"status":1,"userId":53,"isMark":0,"cntn":"gfxfj","lawyer":{"typeName":"合同纠纷,劳动纠纷,侵权纠纷","address":"北京 海淀区","name":"王占强律师","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170710/0954/2017071050626.jpg","period":2,"lawName":"北京市炜衡律师事务所","lawyerNo":"11101201510682627"}}]
         * offerStrt : 0.0
         * typeName : 合同纠纷
         * id : 14
         * fileUrls :
         * title : jj
         * address : 天津 河西区
         * offerEnd : 1.0
         * userId : 63
         * name : nfjjfkd
         * markUserId : 53
         * creatTm : 1500170521000
         * cntn : dhhdhd
         */

        private int status;
        private String tel;
        private double earnest;
        private int markCnt;
        private double offerStrt;
        private String typeName;
        private int id;
        private String fileUrls;
        private String title;
        private String address;
        private double offerEnd;
        private int userId;
        private String name;
        private int markUserId;
        private long creatTm;
        private String cntn;
        private List<ListBean> list;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public double getEarnest() {
            return earnest;
        }

        public void setEarnest(double earnest) {
            this.earnest = earnest;
        }

        public int getMarkCnt() {
            return markCnt;
        }

        public void setMarkCnt(int markCnt) {
            this.markCnt = markCnt;
        }

        public double getOfferStrt() {
            return offerStrt;
        }

        public void setOfferStrt(double offerStrt) {
            this.offerStrt = offerStrt;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFileUrls() {
            return fileUrls;
        }

        public void setFileUrls(String fileUrls) {
            this.fileUrls = fileUrls;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getOfferEnd() {
            return offerEnd;
        }

        public void setOfferEnd(double offerEnd) {
            this.offerEnd = offerEnd;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMarkUserId() {
            return markUserId;
        }

        public void setMarkUserId(int markUserId) {
            this.markUserId = markUserId;
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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 10
             * price : 0.2
             * status : 1
             * userId : 53
             * isMark : 0
             * cntn : gfxfj
             * lawyer : {"typeName":"合同纠纷,劳动纠纷,侵权纠纷","address":"北京 海淀区","name":"王占强律师","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170710/0954/2017071050626.jpg","period":2,"lawName":"北京市炜衡律师事务所","lawyerNo":"11101201510682627"}
             */

            private int id;
            private double price;
            private int status;
            private int userId;
            private int isMark;
            private String cntn;
            private LawyerBean lawyer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getIsMark() {
                return isMark;
            }

            public void setIsMark(int isMark) {
                this.isMark = isMark;
            }

            public String getCntn() {
                return cntn;
            }

            public void setCntn(String cntn) {
                this.cntn = cntn;
            }

            public LawyerBean getLawyer() {
                return lawyer;
            }

            public void setLawyer(LawyerBean lawyer) {
                this.lawyer = lawyer;
            }

            public static class LawyerBean {
                /**
                 * typeName : 合同纠纷,劳动纠纷,侵权纠纷
                 * address : 北京 海淀区
                 * name : 王占强律师
                 * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170710/0954/2017071050626.jpg
                 * period : 2
                 * lawName : 北京市炜衡律师事务所
                 * lawyerNo : 11101201510682627
                 */

                private String typeName;
                private String address;
                private String name;
                private String headUrl;
                private int period;
                private String lawName;
                private String lawyerNo;

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getHeadUrl() {
                    return headUrl;
                }

                public void setHeadUrl(String headUrl) {
                    this.headUrl = headUrl;
                }

                public int getPeriod() {
                    return period;
                }

                public void setPeriod(int period) {
                    this.period = period;
                }

                public String getLawName() {
                    return lawName;
                }

                public void setLawName(String lawName) {
                    this.lawName = lawName;
                }

                public String getLawyerNo() {
                    return lawyerNo;
                }

                public void setLawyerNo(String lawyerNo) {
                    this.lawyerNo = lawyerNo;
                }
            }
        }
    }
}
