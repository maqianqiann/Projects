package com.ken.test.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/15.
 */

public class MoBean {

    /**
     * code : 200
     * msg : success
     * data : [{"id":"121","goods_name":"镇店之宝丨美白嫩肤面膜7片","shop_price":49.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg","sales_volume":122443,"efficacy":"镇店之宝 美白爆款","sort":0},{"id":"389","goods_name":"清爽平衡矿物蚕丝面膜黑面膜21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/389/goods_img/16081909368531961221339216.jpg","sales_volume":101959,"efficacy":"以黑吸黑 净透亮肤","sort":0},{"id":"85","goods_name":"果味鲜饮|水果鲜润亮肤补水面膜套装17片","shop_price":59.9,"market_price":240,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/85/goods_img/160819085747012099748482408.jpg","sales_volume":92390,"efficacy":"水嫩舒爽 鲜活亮颜","sort":0},{"id":"684","goods_name":"解救肌渴丨花粹水润面膜套装10片","shop_price":29.9,"market_price":139,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/684/goods_img/160819095063413908186337181.jpg","sales_volume":85146,"efficacy":"水润充盈 鲜嫩少女肌","sort":0},{"id":"772","goods_name":"清爽亮颜黑面膜套装21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/772/goods_img/1608191429278479187604212.jpg","sales_volume":51607,"efficacy":"热销黑膜 净透亮肤","sort":0},{"id":"8","goods_name":"镇店之宝|美白嫩肤面膜20片","shop_price":119.9,"market_price":298,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/8/goods_img/1703060954389257968293129.jpg","sales_volume":26855,"efficacy":"爆款面膜 明星同款","sort":0},{"id":"83","goods_name":"黑玫瑰矿物蚕丝面膜7片","shop_price":119,"market_price":139,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/83/goods_img/16081908576425344499831215.jpg","sales_volume":26513,"efficacy":"深度保养 补水提亮","sort":0},{"id":"428","goods_name":"多彩水润亮颜蚕丝面膜套装21片","shop_price":79.9,"market_price":270.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/428/goods_img/160819094034113421009937866.jpg","sales_volume":23204,"efficacy":"吸黑焕彩 补水保湿","sort":0},{"id":"257","goods_name":"薰衣草蚕丝面膜7片","shop_price":89,"market_price":109,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/257/goods_img/16081909269443843637779188.jpg","sales_volume":21345,"efficacy":"补水保湿 舒缓修护","sort":0},{"id":"593","goods_name":"热销黑膜丨葡萄籽琉璃亮颜黑面膜21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/593/goods_img/1608190945359698973439364.jpg","sales_volume":18253,"efficacy":"葡萄鲜饮 净透亮肤","sort":0},{"id":"20","goods_name":"清润紧致蚕丝面膜套装21片","shop_price":109.9,"market_price":307,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/20/goods_img/160819084923710469247382812.jpg","sales_volume":15530,"efficacy":"清透滋养 弹嫩紧致","sort":0},{"id":"400","goods_name":"缤纷鲜润矿物蚕丝面膜套装20片","shop_price":79.9,"market_price":279.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/400/goods_img/16081909375548938767322654.jpg","sales_volume":13265,"efficacy":"补水亮肤 缤纷水嫩","sort":0},{"id":"745","goods_name":"红石榴矿物蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/745/goods_img/160819095890910677609745693.jpg","sales_volume":11594,"efficacy":"补水保湿 提亮肤色","sort":0},{"id":"325","goods_name":"竹萃清爽蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/325/goods_img/160819142666914591033736475.jpg","sales_volume":9390,"efficacy":"平衡水油 清爽净透","sort":0},{"id":"1249","goods_name":"口碑推荐|盈透柔肤黑膜组合装42片","shop_price":199.9,"market_price":594,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1249/goods_img/170104100411616941119547437.jpg","sales_volume":8794,"efficacy":"清洁补水 保湿提亮","sort":0},{"id":"161","goods_name":"男士补水活力矿物蚕丝7片 今日送7片共14片","shop_price":59.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/161/goods_img/16081909077546170320476224.jpg","sales_volume":8171,"efficacy":"补水保湿 清爽控油","sort":0},{"id":"708","goods_name":"水果护肤力量丨鲜果缤纷黑白面膜套装42片","shop_price":209.9,"market_price":594,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/708/goods_img/16082615049413682815961884.jpg","sales_volume":7146,"efficacy":"新品组合 鲜果养肤","sort":0},{"id":"319","goods_name":"男士补水活力矿物蚕丝21片","shop_price":79.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/319/goods_img/16081909273161845841818485.jpg","sales_volume":6294,"efficacy":"补水保湿 清爽控油","sort":0},{"id":"622","goods_name":"葡萄籽琉璃亮颜黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/622/goods_img/160819094698413173347474163.jpg","sales_volume":6198,"efficacy":"葡萄鲜饮 净透亮肤","sort":0},{"id":"921","goods_name":"甜橙晶透亮颜矿物面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/921/goods_img/161018083525512130589201446.jpg","sales_volume":5430,"efficacy":"提亮肤色 修护肌肤","sort":0},{"id":"1189","goods_name":"清透水嫩亮颜黑面膜套装21片（买就送清爽平衡矿物蚕丝7片）","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1189/goods_img/17033018357451202108009476.jpg","sales_volume":5407,"efficacy":"净透补水 润泽提亮","sort":0},{"id":"557","goods_name":"水润清透养肤面膜套装42片","shop_price":179.9,"market_price":634,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/557/goods_img/160819094421515862876125825.jpg","sales_volume":5237,"efficacy":"清透补水 滋润修护","sort":0},{"id":"163","goods_name":"清爽平衡矿物蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/163/goods_img/160819090788311035481315778.jpg","sales_volume":4753,"efficacy":"补水控油 清爽保湿","sort":0},{"id":"868","goods_name":"男士黑茶清爽矿物面膜  今日买5片送5片","shop_price":49.9,"market_price":150,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/868/goods_img/1608191430564693145258305.jpg","sales_volume":4107,"efficacy":"洁净控油 强劲清爽","sort":0},{"id":"534","goods_name":"净透美白矿物蚕丝面膜套装28片","shop_price":139.9,"market_price":396,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/534/goods_img/160819094245115265661305031.jpg","sales_volume":3908,"efficacy":"清洁净透 以白养白","sort":0},{"id":"81","goods_name":"人参矿物蚕丝面膜7片","shop_price":89,"market_price":109,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/81/goods_img/160819085711519851862212059.jpg","sales_volume":3799,"efficacy":"提拉紧致 补水保湿","sort":0},{"id":"334","goods_name":"清爽平衡矿物蚕丝面膜黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/334/goods_img/160819092848420294792181143.jpg","sales_volume":3775,"efficacy":"清洁焕彩 净透亮肤","sort":0},{"id":"1251","goods_name":"水果缤纷面膜超值装35片","shop_price":169.9,"market_price":495,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1251/goods_img/170104095895513706519167911.jpg","sales_volume":3697,"efficacy":"清洁控油 补水提亮","sort":0},{"id":"920","goods_name":"法国珍珠藻清透面膜5片","shop_price":59.9,"market_price":79,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/920/goods_img/16081217454451202108002265.jpg","sales_volume":3567,"efficacy":"平衡水油 净彻亮肤","sort":0},{"id":"1234","goods_name":"热销|樱桃鲜润补水矿物面膜7片","shop_price":39.9,"market_price":99,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1234/goods_img/161122183456315727984418108.jpg","sales_volume":2578,"efficacy":"补水保湿  润泽滋养","sort":0}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 121
         * goods_name : 镇店之宝丨美白嫩肤面膜7片
         * shop_price : 49.9
         * market_price : 99.0
         * is_coupon_allowed : true
         * is_allow_credit : false
         * goods_img : https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg
         * sales_volume : 122443
         * efficacy : 镇店之宝 美白爆款
         * sort : 0
         */

        private String id;
        private String goods_name;
        private double shop_price;
        private double market_price;
        private boolean is_coupon_allowed;
        private boolean is_allow_credit;
        private String goods_img;
        private int sales_volume;
        private String efficacy;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public double getMarket_price() {
            return market_price;
        }

        public void setMarket_price(double market_price) {
            this.market_price = market_price;
        }

        public boolean isIs_coupon_allowed() {
            return is_coupon_allowed;
        }

        public void setIs_coupon_allowed(boolean is_coupon_allowed) {
            this.is_coupon_allowed = is_coupon_allowed;
        }

        public boolean isIs_allow_credit() {
            return is_allow_credit;
        }

        public void setIs_allow_credit(boolean is_allow_credit) {
            this.is_allow_credit = is_allow_credit;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
