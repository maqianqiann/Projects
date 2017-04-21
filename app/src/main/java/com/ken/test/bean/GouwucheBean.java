package com.ken.test.bean;

import java.util.ArrayList;

/**
 * 类的用途：
 * 作者：dell
 * 时间： 2017/4/21 16:28
 */

public class GouwucheBean {

    private ArrayList<CartItemList> cartItemList;

    public ArrayList<CartItemList> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(ArrayList<CartItemList> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public class CartItemList{
        private int count;
        private String  name;
        private String pic;
        private String price;
        private Boolean flag =false;

        public Boolean getFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "count=" + count +
                    ", name='" + name + '\'' +
                    ", pic='" + pic + '\'' +
                    ", price='" + price ;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }


}
