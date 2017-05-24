package com.example.echolin.week7.beans;

import java.util.List;

/**
 * Created by echolin on 2017/5/23.
 */

public class HeadView {

    /**
     * status : 0
     * msg : OK
     * data : [{"bannerid":"1760","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/22/5922c227dc0f8.jpg","description":"","userid":"966206","addtime":"1495450152","uptime":"1495450152","orderid":"8","cateid":"0","count_click":"163","status":"1","start_time":"1495468800","end_time":"1495555140","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.vmovier.com\\/fan281?inner_app=1\",\"app_show_type\":null}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.vmovier.com/fan281?inner_app=1","app_show_type":""}},{"bannerid":"1759","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/22/5922bab1319f1.jpg","description":"","userid":"551913","addtime":"1495449299","uptime":"1495449299","orderid":"7","cateid":"0","count_click":"350","status":"1","start_time":"1495448220","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.vmovier.com\\/activity\\/182\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.vmovier.com/activity/182","app_show_type":"all"}},{"bannerid":"1756","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/22/592252d9d767b.jpg","description":"","userid":"927555","addtime":"1495421658","uptime":"1495421658","orderid":"6","cateid":"0","count_click":"571","status":"1","start_time":"1495421657","end_time":"0","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"51812\",\"app_show_type\":null}","extra_data":{"app_banner_type":"2","app_banner_param":"51812","app_show_type":"","is_album":"0"}},{"bannerid":"1720","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/15/59191eff4c3d6.jpg","description":"","userid":"551913","addtime":"1494818559","uptime":"1494818559","orderid":"5","cateid":"0","count_click":"279","status":"1","start_time":"1494387720","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/ilovevmovier.mikecrm.com\\/mcGeuKy\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://ilovevmovier.mikecrm.com/mcGeuKy","app_show_type":"all"}},{"bannerid":"1736","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/15/5919be7aeb216.jpg","description":"","userid":"927555","addtime":"1494859387","uptime":"1494859387","orderid":"4","cateid":"0","count_click":"409","status":"1","start_time":"1494859386","end_time":"0","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"51722\",\"app_show_type\":null}","extra_data":{"app_banner_type":"2","app_banner_param":"51722","app_show_type":"","is_album":"0"}},{"bannerid":"1727","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/13/5916778be4168.jpg","description":"","userid":"919390","addtime":"1494644620","uptime":"1494644620","orderid":"3","cateid":"0","count_click":"127","status":"1","start_time":"1494644619","end_time":"0","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"51765\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"2","app_banner_param":"51765","app_show_type":"all","is_album":"0"}},{"bannerid":"1644","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/04/06/58e627b6da93a.jpg","description":"","userid":"551913","addtime":"1492166081","uptime":"1492166081","orderid":"2","cateid":"0","count_click":"12902","status":"1","start_time":"1491478440","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"https:\\/\\/kdt.im\\/QLJqvr\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"https://kdt.im/QLJqvr","app_show_type":"all"}},{"bannerid":"1746","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/05/16/591b1938bc554.jpg","description":"","userid":"962854","addtime":"1494948205","uptime":"1494948205","orderid":"1","cateid":"0","count_click":"544","status":"1","start_time":"1494948120","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.xinpianchang.com\\/activity\\/independence\\/ts-thriller\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.xinpianchang.com/activity/independence/ts-thriller","app_show_type":"all"}}]
     */

    private String status;
    private String msg;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bannerid : 1760
         * type : 7
         * object_id : 0
         * title :
         * url : /
         * image : http://cs.vmoiver.com/Uploads/Banner/2017/05/22/5922c227dc0f8.jpg
         * description :
         * userid : 966206
         * addtime : 1495450152
         * uptime : 1495450152
         * orderid : 8
         * cateid : 0
         * count_click : 163
         * status : 1
         * start_time : 1495468800
         * end_time : 1495555140
         * extra : {"app_banner_type":"1","app_banner_param":"http:\/\/www.vmovier.com\/fan281?inner_app=1","app_show_type":null}
         * extra_data : {"app_banner_type":"1","app_banner_param":"http://www.vmovier.com/fan281?inner_app=1","app_show_type":""}
         */

        private String bannerid;
        private String type;
        private String object_id;
        private String title;
        private String url;
        private String image;
        private String description;
        private String userid;
        private String addtime;
        private String uptime;
        private String orderid;
        private String cateid;
        private String count_click;
        private String status;
        private String start_time;
        private String end_time;
        private String extra;
        private ExtraDataBean extra_data;

        public String getBannerid() {
            return bannerid;
        }

        public void setBannerid(String bannerid) {
            this.bannerid = bannerid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getCount_click() {
            return count_click;
        }

        public void setCount_click(String count_click) {
            this.count_click = count_click;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }

        public ExtraDataBean getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(ExtraDataBean extra_data) {
            this.extra_data = extra_data;
        }

        public static class ExtraDataBean {
            /**
             * app_banner_type : 1
             * app_banner_param : http://www.vmovier.com/fan281?inner_app=1
             * app_show_type :
             */

            private String app_banner_type;
            private String app_banner_param;
            private String app_show_type;

            public String getApp_banner_type() {
                return app_banner_type;
            }

            public void setApp_banner_type(String app_banner_type) {
                this.app_banner_type = app_banner_type;
            }

            public String getApp_banner_param() {
                return app_banner_param;
            }

            public void setApp_banner_param(String app_banner_param) {
                this.app_banner_param = app_banner_param;
            }

            public String getApp_show_type() {
                return app_show_type;
            }

            public void setApp_show_type(String app_show_type) {
                this.app_show_type = app_show_type;
            }
        }
    }
}
