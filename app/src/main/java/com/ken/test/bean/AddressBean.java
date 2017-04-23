package com.ken.test.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/23.
 */

public class AddressBean {

    /**
     * data : [{"areaDetail":"beijing","areaId":"beijing","cityId":"beijing","fixedtel":"beijing","id":1013,"name":"merry","phoneNumber":"15718812708","provinceId":"beijing","zipCode":"64"}]
     * response : addressDefault
     */

    private String response;
    private List<DataBean> data;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * areaDetail : beijing
         * areaId : beijing
         * cityId : beijing
         * fixedtel : beijing
         * id : 1013
         * name : merry
         * phoneNumber : 15718812708
         * provinceId : beijing
         * zipCode : 64
         */

        private String areaDetail;
        private String areaId;
        private String cityId;
        private String fixedtel;
        private int id;
        private String name;
        private String phoneNumber;
        private String provinceId;
        private String zipCode;

        public String getAreaDetail() {
            return areaDetail;
        }

        public void setAreaDetail(String areaDetail) {
            this.areaDetail = areaDetail;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getFixedtel() {
            return fixedtel;
        }

        public void setFixedtel(String fixedtel) {
            this.fixedtel = fixedtel;
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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
