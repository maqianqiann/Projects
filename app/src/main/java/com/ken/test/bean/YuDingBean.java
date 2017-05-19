package com.ken.test.bean;

/**
 * Created by lenovo on 2017/4/25.
 */

public class YuDingBean {

    /**
     * code : 0
     * msg : 订单添加成功
     * data : {"shop_id":"1","activity_id":4,"order_sn":"2017042508424584486","goods_name":"挑战意大利主厨丨我的披萨我做主","user_id":"465","contact":"马倩","mobile":"15718812708","remark":"1","child_price":"88.00","child_num":1,"adult_price":"0.01","adult_num":0,"order_amount":88,"amount":88,"status":1,"account_rate":0.99,"activity_start_time":"1494635400","activity_end_time":"1494646200","shop_name":"北京乐学三六五教育科技","shop_address":"亦庄经开大厦","activity_address":"亦庄必胜客餐厅","shop_tel":"18888338832","create_time":1493080965,"ip":"222.128.177.144","order_id":"234"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shop_id : 1
         * activity_id : 4
         * order_sn : 2017042508424584486
         * goods_name : 挑战意大利主厨丨我的披萨我做主
         * user_id : 465
         * contact : 马倩
         * mobile : 15718812708
         * remark : 1
         * child_price : 88.00
         * child_num : 1
         * adult_price : 0.01
         * adult_num : 0
         * order_amount : 88
         * amount : 88
         * status : 1
         * account_rate : 0.99
         * activity_start_time : 1494635400
         * activity_end_time : 1494646200
         * shop_name : 北京乐学三六五教育科技
         * shop_address : 亦庄经开大厦
         * activity_address : 亦庄必胜客餐厅
         * shop_tel : 18888338832
         * create_time : 1493080965
         * ip : 222.128.177.144
         * order_id : 234
         */

        private String shop_id;
        private int activity_id;
        private String order_sn;
        private String goods_name;
        private String user_id;
        private String contact;
        private String mobile;
        private String remark;
        private String child_price;
        private int child_num;
        private String adult_price;
        private int adult_num;
        private int order_amount;
        private int amount;
        private int status;
        private double account_rate;
        private String activity_start_time;
        private String activity_end_time;
        private String shop_name;
        private String shop_address;
        private String activity_address;
        private String shop_tel;
        private int create_time;
        private String ip;
        private String order_id;

        public String getShop_id() {
            return shop_id;
        }

        public void setShop_id(String shop_id) {
            this.shop_id = shop_id;
        }

        public int getActivity_id() {
            return activity_id;
        }

        public void setActivity_id(int activity_id) {
            this.activity_id = activity_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getChild_price() {
            return child_price;
        }

        public void setChild_price(String child_price) {
            this.child_price = child_price;
        }

        public int getChild_num() {
            return child_num;
        }

        public void setChild_num(int child_num) {
            this.child_num = child_num;
        }

        public String getAdult_price() {
            return adult_price;
        }

        public void setAdult_price(String adult_price) {
            this.adult_price = adult_price;
        }

        public int getAdult_num() {
            return adult_num;
        }

        public void setAdult_num(int adult_num) {
            this.adult_num = adult_num;
        }

        public int getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(int order_amount) {
            this.order_amount = order_amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getAccount_rate() {
            return account_rate;
        }

        public void setAccount_rate(double account_rate) {
            this.account_rate = account_rate;
        }

        public String getActivity_start_time() {
            return activity_start_time;
        }

        public void setActivity_start_time(String activity_start_time) {
            this.activity_start_time = activity_start_time;
        }

        public String getActivity_end_time() {
            return activity_end_time;
        }

        public void setActivity_end_time(String activity_end_time) {
            this.activity_end_time = activity_end_time;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getShop_address() {
            return shop_address;
        }

        public void setShop_address(String shop_address) {
            this.shop_address = shop_address;
        }

        public String getActivity_address() {
            return activity_address;
        }

        public void setActivity_address(String activity_address) {
            this.activity_address = activity_address;
        }

        public String getShop_tel() {
            return shop_tel;
        }

        public void setShop_tel(String shop_tel) {
            this.shop_tel = shop_tel;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }
    }
}
