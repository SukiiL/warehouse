package com.crud.demo.service.impl;

import com.crud.demo.entity.dailyPack.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyPack.DailySku;
import com.crud.demo.entity.dailyPack.DailyTotal;
import com.crud.demo.entity.dailySales.DailySales;
import com.crud.demo.entity.dailySales.ReturnMiscPortion;
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
    public DailyTotal findPackAvg (RequestBrand brandInfo) {
        // 判断商家是否存在
        DailyTotal avgInfo = dailyPackMapper.findPackAvg(brandInfo);
        //将当前商家数据返回
        return avgInfo;
    }

    @Override
    public List<DailyMaterial> countMaterialNum(RequestBrand brandInfo){
        List<DailyMaterial> selectRes = dailyPackMapper.countMaterialNum(brandInfo);
        return selectRes;
    }

    @Override
    public List<DailySku> countSkuRank(RequestBrand brandInfo) {
        List<DailySku> selectRes = dailyPackMapper.countSkuRank(brandInfo);
        return selectRes;
    }

    @Override
    public List<DailySku> countPackGood(RequestBrand brandInfo){
        List<DailySku> selectRes = dailyPackMapper.countPackGood(brandInfo);
        return selectRes;
    }

    @Override
    public DailySku countAvgSku(RequestBrand brandInfo){
        DailySku selectRes = dailyPackMapper.countAvgSku(brandInfo);
        return selectRes;

    }

    @Override
    public ReturnMiscPortion countMiscPortion (RequestBrand brandInfo) {
        List<DailySales> goodMisc = dailyPackMapper.goodMiscPortion(brandInfo);
        DailyTotal packMisc = dailyPackMapper.packMiscPortion(brandInfo);
        ReturnMiscPortion miscInfo = new ReturnMiscPortion();
        miscInfo.setGoodStat(goodMisc);
        miscInfo.setPackStat(packMisc);
//        int n = brandInfo.getN();
//        return salesInfo.size() <= n ? salesInfo : salesInfo.subList(0,n);
        return miscInfo;
    }

}
