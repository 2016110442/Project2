package com.project1.response;

public class CommonReturnType {
    //表明对应请求的返回结果"successs" or "fail"
    private String status1;

    //如果status为success，data内返回前端需要的json数据
    //如果为fail,data内使用通用的错误码格式
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus1(status);
        type.setData(result);
        return type;
    }


    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
