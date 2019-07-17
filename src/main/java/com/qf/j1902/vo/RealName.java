package com.qf.j1902.vo;

/**
 * Created by Administrator on 2019/6/12.
 */

public class RealName {
        private int id;
        private String name;
        private String rzType;
        private String realName;
        private String cardnum;
        private String tel;
        private String cardimg;
        private String email;
        private String zhuangtai;

    public RealName() {
    }

    public RealName(int id, String name, String rzType, String realName, String cardnum, String tel, String cardimg, String email, String zhuangtai) {
        this.id = id;
        this.name = name;
        this.rzType = rzType;
        this.realName = realName;
        this.cardnum = cardnum;
        this.tel = tel;
        this.cardimg = cardimg;
        this.email = email;
        this.zhuangtai = zhuangtai;
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

    public String getRzType() {
        return rzType;
    }

    public void setRzType(String rzType) {
        this.rzType = rzType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    @Override
    public String toString() {
        return "RealName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rzType='" + rzType + '\'' +
                ", realName='" + realName + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", tel='" + tel + '\'' +
                ", cardimg='" + cardimg + '\'' +
                ", email='" + email + '\'' +
                ", zhuangtai='" + zhuangtai + '\'' +
                '}';
    }
}
