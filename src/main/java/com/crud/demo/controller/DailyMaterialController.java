package com.crud.demo.controller;

import com.crud.demo.entity.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.service.DailyMaterialService;
import com.crud.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily_material")
public class DailyMaterialController extends BaseController{

    @Autowired
    private DailyMaterialService dailyMaterialService;


    @RequestMapping(value = "/countMaterialNum", method = RequestMethod.POST)
    public JsonResult<List<DailyMaterial>> countMaterialNum(@RequestBody RequestBrand brandInfo){
        List<DailyMaterial> data = dailyMaterialService.countMaterialNum(brandInfo);
        JsonResult<List<DailyMaterial>> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }


}
