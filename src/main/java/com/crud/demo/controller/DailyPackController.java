package com.crud.demo.controller;

import com.crud.demo.entity.dailyPack.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyPack.DailySku;
import com.crud.demo.entity.dailyPack.ReturnAvg;
import com.crud.demo.service.DailyPackService;
import com.crud.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dailyPack")
public class DailyPackController extends BaseController{

        @Autowired
        private DailyPackService dailyPackService;

        /**
         * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
         */
        @RequestMapping(value = "/findPackAvg", method = RequestMethod.POST)
        public JsonResult<ReturnAvg> findPackAvg(@RequestBody RequestBrand brandInfo){
            ReturnAvg data = dailyPackService.findPackAvg(brandInfo);
            JsonResult<ReturnAvg> r = new JsonResult<>(OK,data);
            r.setMessage("操作成功");
            return r;
        }

        /**
         * 根据bid和date查找商家各包材使用数目及占比，倒序排列。
         */
        @RequestMapping(value = "/countMaterialNum", method = RequestMethod.POST)
        public JsonResult<List<DailyMaterial>> countMaterialNum(@RequestBody RequestBrand brandInfo){
            List<DailyMaterial> data = dailyPackService.countMaterialNum(brandInfo);
            JsonResult<List<DailyMaterial>> r = new JsonResult<>(OK,data);
            r.setMessage("操作成功");
            return r;
        }

        /**
         * 根据bid和date查找商家各包材使用数目及占比，倒序排列。
         */
        @RequestMapping(value = "/countSkuRank", method = RequestMethod.POST)
        public JsonResult<List<DailySku>> countSkuRank(@RequestBody RequestBrand brandInfo){
            List<DailySku> data = dailyPackService.countSkuRank(brandInfo);
            JsonResult<List<DailySku>> r = new JsonResult<>(OK,data);
            r.setMessage("操作成功");
            return r;
        }



}

