package com.crud.demo.service.impl;

import com.crud.demo.entity.dailyPack.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyPack.DailySku;
import com.crud.demo.entity.dailyPack.ReturnAvg;
import com.crud.demo.mapper.DailyPackMapper;
import com.crud.demo.service.DailyPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DailyPackServiceImpl implements DailyPackService {

    @Autowired
    private DailyPackMapper dailyPackMapper;


    @Override
    public ReturnAvg findPackAvg (RequestBrand brandInfo) {
        // 判断商家是否存在
        ReturnAvg avgInfo = dailyPackMapper.findPackAvg(brandInfo);
        //将当前商家数据返回
        return avgInfo;
    }

    @Override
    public List<DailyMaterial> countMaterialNum(RequestBrand brandInfo){
        List<DailyMaterial> selectRes = dailyPackMapper.countMaterialNum(brandInfo);
        return selectRes;
    }

    @Override
    public List<DailySku> countSkuRank(RequestBrand brandInfo){
        List<DailySku> selectRes = dailyPackMapper.countSkuRank(brandInfo);
        return selectRes;
    }

}
