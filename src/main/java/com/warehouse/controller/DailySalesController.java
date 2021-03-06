package com.warehouse.controller;

import com.warehouse.entity.dailySales.DailySales;
import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailySales.ReturnDailyGood;
import com.warehouse.service.DailySalesService;
import com.warehouse.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailySales")
public class DailySalesController extends BaseController {

    @Autowired
    private DailySalesService dailySalesService;


    @RequestMapping(value = "/countSalesRank", method = RequestMethod.POST)
    public JsonResult<List<DailySales>> countSalesRank(@RequestBody RequestBrand brandInfo) {
        List<DailySales> data = dailySalesService.countSalesRank(brandInfo);
        JsonResult<List<DailySales>> r = new JsonResult<>(OK, data);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 根据bid和date查找商家日发货量的集合，集合均值、最大值、最低值、中位数、标差
     */
    @RequestMapping(value = "/countDailyGood", method = RequestMethod.POST)
    public JsonResult<ReturnDailyGood> countDailyGood(@RequestBody RequestBrand brandInfo) {
        ReturnDailyGood data = dailySalesService.countDailyGood(brandInfo);
        JsonResult<ReturnDailyGood> r = new JsonResult<>(OK, data);
        r.setMessage("操作成功");
        return r;
    }
}
