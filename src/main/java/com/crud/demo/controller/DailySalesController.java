package com.crud.demo.controller;

import com.crud.demo.entity.DailySales;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.service.DailySalesService;
import com.crud.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily_sales")
public class DailySalesController extends BaseController{

    @Autowired
    private DailySalesService dailySalesService;


    @RequestMapping(value = "/countSalesRank", method = RequestMethod.POST)
    public JsonResult<List<DailySales>> countSalesRank(@RequestBody RequestBrand brandInfo){
        List<DailySales> data = dailySalesService.countSalesRank(brandInfo);
        JsonResult<List<DailySales>> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }


}
