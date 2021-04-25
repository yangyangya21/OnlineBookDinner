package com.yjq.server.dto;


/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2020-09-20 10:34
 */

import com.yjq.server.bean.CodeMsg;

/**
 * 返回类数据传输对象  作用于service和controller
 * @param <T>
 */
public class ResponseDto<T> {
    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseDto(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResponseDto(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(CodeMsg.SUCCESS.getCode(), data);
    }

    public static <T> ResponseDto<T> successByMsg(T data, String msg) {
        return new ResponseDto<>(CodeMsg.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseDto<T> errorByMsg(CodeMsg codeMsg) {
        return new ResponseDto<>(codeMsg.getCode(),codeMsg.getMsg());
    }

}
