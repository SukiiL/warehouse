package com.crud.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 以json格式的数据对前端进行响应
 */

@Data
public class JsonResult<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer state; //状态码

    private String message; //描述信息

    private E data;

    public  JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult (Integer state, E data) {
        this.state = state;
        this.data = data;
    }

}
