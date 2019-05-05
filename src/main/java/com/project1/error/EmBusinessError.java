package com.project1.error;

public enum EmBusinessError implements CommonError{
    //通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    //枚举本质上是面向对象的类
    //定义一个简单的错误码
    //200000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在"),
    USER_IS_EXIST(20002,"用户已存在"),

    USER_PASSWORD_ERROR(20003,"用户密码错误")
    ;

    private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
