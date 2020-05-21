package com.example.consult.entity;

public enum ResultCode {

    SUCCESS("200","成功"),
    ERROR("500","服务器错误"),
    REPEAT("1001", "账号重复"),
    FAIL("400","失败");



    private String val;
    private String msg;

    public String val(){
        return val;
    }

    public String msg(){
        return msg;
    }

    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;

    }


}
