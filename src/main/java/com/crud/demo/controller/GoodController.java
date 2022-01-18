package com.crud.demo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.crud.demo.entity.Good;
import com.crud.demo.service.GoodService;
import com.crud.demo.service.exception.ImportException;
import com.crud.demo.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController // = @Controller + @ResponseBody 响应结果以json格式给到前端
@RequestMapping("/good")
@Slf4j
public class GoodController extends BaseController{

    @Autowired
    private GoodService goodService;



    //通过gid删除用户
    //    http://localhost:8080/good/deleteByGid?1(此处1为要删除的id）
    @RequestMapping(value = "/deleteByGid/{gid}", method = RequestMethod.GET)
    public JsonResult<Void> deleteByGid(@PathVariable int gid){
        goodService.deleteByGid(gid);
        JsonResult r = new JsonResult<>(OK);
        r.setMessage("操作成功");
        return r;
    }

    //通过bid获取商品
    //    http://localhost:8080/good/findByBid/1(此处1为商家的bid）
    @RequestMapping(value = "findByBid/{bid}", method = RequestMethod.GET)
    public JsonResult<List<Good>> findByBid(@PathVariable int bid){
        List<Good> data = goodService.findByBid(bid);
        System.out.println(data);
        JsonResult<List<Good>> r = new JsonResult<>(OK,data);
        r.setMessage("操作成功");
        return r;
    }


    //增/改商品信息
    //http://localhost:8080/good/insert
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public JsonResult<Void> insert(@RequestBody List<Good> goodList){
        goodService.insert(goodList);
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
        List<Good> importList = ExcelImportUtil.importExcel(excelFile.getInputStream(), Good.class, params);
        goodService.insert(importList);
        JsonResult r = new JsonResult<>(OK);
        r.setMessage("操作成功");
        return r;
    }


}
