package com.example.consult.entity;

public enum ResultCode {

    SUCCESS("200","成功"),

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
