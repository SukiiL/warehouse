package com.warehouse.controller;

import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailyPack.DailyMaterial;
import com.warehouse.entity.dailyPack.DailySku;
import com.warehouse.entity.dailyPack.DailyTotal;
import com.warehouse.entity.dailyPack.EfficiencyPerArea;
import com.warehouse.entity.dailySales.ReturnMiscPortion;
import com.warehouse.service.DailyPackService;
import com.warehouse.util.JsonResult;
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
    public JsonResult<DailyTotal> findPackAvg(@RequestBody RequestBrand brandInfo){
        DailyTotal data = dailyPackService.findPackAvg(brandInfo);
        JsonResult<DailyTotal> r = new JsonResult<>(OK,data);
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

    /**
     * 根据bid和date查找商家各sku数目下的商品数
     */
    @RequestMapping(value = "/countPackGood", method = RequestMethod.POST)
    public JsonResult<List<DailySku>> countPackGood(@RequestBody RequestBrand brandInfo){
        List<DailySku> data = dailyPackService.countPackGood(brandInfo);
        JsonResult<List<DailySku>> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 根据bid和date查找商家sku > 1的包裹的平均sku数
     */
    @RequestMapping(value = "/countAvgSku", method = RequestMethod.POST)
    public JsonResult<DailySku> countAvgSku(@RequestBody RequestBrand brandInfo){
        DailySku data = dailyPackService.countAvgSku(brandInfo);
        JsonResult<DailySku> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 根据bid,date,n查找销量前N的商品中，杂单包裹所占的比例；以及，商家在日期区间中，所售全部包裹中，杂单包裹所占的比例。
     */
    @RequestMapping(value = "/countMiscPortion", method = RequestMethod.POST)
    public JsonResult<ReturnMiscPortion> countMiscPortion(@RequestBody RequestBrand brandInfo){
        ReturnMiscPortion data = dailyPackService.countMiscPortion(brandInfo);
        JsonResult<ReturnMiscPortion> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 根据bid,date,n查找商家平效
     */
    @RequestMapping(value = "/countEfficiency", method = RequestMethod.POST)
    public JsonResult<List<EfficiencyPerArea>> countEfficiency(@RequestBody RequestBrand brandInfo){
        List<EfficiencyPerArea> data = dailyPackService.countEfficiency(brandInfo);
        JsonResult<List<EfficiencyPerArea>> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }
}


