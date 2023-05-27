package com.example.dean;

public class HelpKH {
    String name, sex, phone, address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HelpKH(String name, String sex, String phone, String address) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }
    public HelpKH(){

    }

}
