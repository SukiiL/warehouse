package com.crud.demo.controller;

import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyAvg.ReturnAvg;
import com.crud.demo.entity.dailyAvg.ReturnDailyGood;
import com.crud.demo.service.DailyAvgService;
import com.crud.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daily_total")
public class DailyAvgController extends BaseController{

        @Autowired
        private DailyAvgService dailyAvgService;

        /**
         * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
         */
        @RequestMapping(value = "/findPackAvg", method = RequestMethod.POST)
        public JsonResult<ReturnAvg> findPackAvg(@RequestBody RequestBrand brandInfo){
            ReturnAvg data = dailyAvgService.findPackAvg(brandInfo);
            JsonResult<ReturnAvg> r = new JsonResult<>(OK,data);
            r.setMessage("操作成功");
            return r;
        }

        /**
         * 根据bid和date查找商家日发货量的集合，集合均值、最大值、最低值、中位数、标差
         */
        @RequestMapping(value = "/countDailyGood", method = RequestMethod.POST)
        public JsonResult<ReturnDailyGood> countDailyGood(@RequestBody RequestBrand brandInfo){
            ReturnDailyGood data = dailyAvgService.countDailyGood(brandInfo);
            JsonResult<ReturnDailyGood> r = new JsonResult<>(OK,data);
            r.setMessage("操作成功");
            return r;
    }

}

