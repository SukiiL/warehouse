package com.warehouse.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.warehouse.entity.Brand;
import com.warehouse.service.BrandService;
import com.warehouse.service.exception.ImportException;
import com.warehouse.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@RestController
@RequestMapping(value = "/brand")
@Slf4j
public class BrandController extends BaseController{

    @Autowired
    private BrandService brandService;

    /**
     * 刪除
     **/
    @RequestMapping(value = "/deleteByBid/{bid}", method = RequestMethod.GET)
    public JsonResult<Void> deleteByBid(@PathVariable int bid){
        brandService.deleteByBid(bid);
        JsonResult r = new JsonResult<>(OK);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 增/改
     **/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public JsonResult<Void> insert(@RequestBody List<Brand> brandList){
        brandService.insert(brandList);
        JsonResult r = new JsonResult<>(OK);
        r.setMessage("操作成功");
        return r;
    }

    //导入Excel文件
    @RequestMapping("/import")
    public JsonResult<Void> importExcel(MultipartFile excelFile) throws Exception{
        log.info("文件名: [{}]",excelFile.getOriginalFilename());
        String str = excelFile.getOriginalFilename();
        int idx = str.lastIndexOf(".");
        str = str.substring(idx + 1, str.length());
        if(!str.equals("xls") && !str.equals("xlsx")){
            throw new ImportException("文件格式只能为.xls/.xlsx");
        }
        //excel导入
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<Brand> importList = ExcelImportUtil.importExcel(excelFile.getInputStream(), Brand.class, params);
        brandService.insert(importList);
        JsonResult r = new JsonResult<>(OK);
        r.setMessage("操作成功");
        return r;
    }



}