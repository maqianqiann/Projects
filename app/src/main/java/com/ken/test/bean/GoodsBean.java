package com.ken.test.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */

public class GoodsBean  {

    /**
     * cartItemList : [{"colorID":2,"count":2,"id":20,"name":"水水润润 修护受损","pic":"http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg","price":59,"productID":2,"repertory":888,"sizeID":2,"userID":64},{"colorID":2,"count":2,"id":21,"name":"温和清洁 补水保湿","pic":"http://image.hmeili.com/yunifang/images/goods/101/goods_img/160819085919220738763253204.jpg","price":29.9,"productID":2,"repertory":888,"sizeID":2,"userID":64},{"colorID":2,"count":2,"id":22,"name":"鲜果酵素 弹嫩水润","pic":"https://image.yunifang.com/yunifang/images/goods/1638/goods_img/17030210211762506087062132.jpg","price":299,"productID":2,"repertory":888,"sizeID":2,"userID":64},{"colorID":2,"count":2,"id":24,"name":"深层清洁 平衡水油","pic":"http://image.hmeili.com/yunifang/images/goods/189/goods_img/160819091183119066095185335.jpg","price":179.9,"productID":2,"repertory":888,"sizeID":2,"userID":64}]
     * response : cart
     */

    private String response;
    private List<CartItemListBean> cartItemList;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<CartItemListBean> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItemListBean> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public static class CartItemListBean {
        /**
         * colorID : 2
         * count : 2
         * id : 20
         * name : 水水润润 修护受损
         * pic : http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg
         * price : 59
         * productID : 2
         * repertory : 888
         * sizeID : 2
         * userID : 64
         */

        private int colorID;
        private int count;
        private int id;
        private String name;
        private String pic;
        private double price;
        private int productID;
        private int repertory;
        private int sizeID;
        private int userID;

        public int getColorID() {
            return colorID;
        }

        public void setColorID(int colorID) {
            this.colorID = colorID;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getProductID() {
            return productID;
        }

        public void setProductID(int productID) {
            this.productID = productID;
        }

        public int getRepertory() {
            return repertory;
        }

        public void setRepertory(int repertory) {
            this.repertory = repertory;
        }

        public int getSizeID() {
            return sizeID;
        }

        public void setSizeID(int sizeID) {
            this.sizeID = sizeID;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }
    }
}
