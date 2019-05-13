package com.project1.service.model;

public class LoginModel {
    private String tel;

    private String pw;

    public LoginModel(String tel, String pw) {
        this.tel = tel;
        this.pw = pw;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
