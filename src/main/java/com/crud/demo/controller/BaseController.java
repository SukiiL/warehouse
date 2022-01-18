package com.crud.demo.controller;

import com.crud.demo.service.exception.*;
import com.crud.demo.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制层的基类，主要用于处理异常
 */
public class BaseController {

    public static final int OK = 200; //操作成功的状态码

//    项目中产生的异常，被统一拦截到此方法中
//    自动将异常对象传递给此方法的参数列表
//    此方法此时充当的就是请求处理方法，返回值给到前端

    @ExceptionHandler(ServiceException.class) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof BrandNotFoundException){
            result.setState(4000);
            result.setMessage("商家不存在");
        } else if(e instanceof GoodNotFoundException){
            result.setState(4001);
            result.setMessage("商品不存在");
        } else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("商品录入时产生未知的异常");
        } else if(e instanceof DeleteException){
            result.setState(5001);
            result.setMessage("删除时产生未知的异常");
        } else if(e instanceof ImportException){
            result.setState(6000);
            result.setMessage("文件格式只能为.xls/.xlsx");
        }
        return result;
    }

}
