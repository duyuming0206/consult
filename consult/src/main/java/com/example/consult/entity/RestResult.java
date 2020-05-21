package com.example.consult.entity;

public class RestResult {

    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestResult(){
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");
    }

    public RestResult(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public RestResult(ResultCode code, Object data) {
        this.setCode(code);
        this.setMessage(code.msg());
        this.setData(data);
    }

    public RestResult(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public RestResult(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

}
