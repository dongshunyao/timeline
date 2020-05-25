package com.bjtu.timeline.bean;

import lombok.Data;

@Data
public class User {
    private int uid;

    private int phone;

    private String nickname;

    private String password;

    private boolean isVIP;

    private long regtime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public long getRegtime() {
        return regtime;
    }

    public void setRegtime(long regtime) {
        this.regtime = regtime;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
