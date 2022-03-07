package com.warehouse.service.impl;

import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailyPack.DailyMaterial;
import com.warehouse.entity.dailyPack.DailySku;
import com.warehouse.entity.dailyPack.DailyTotal;
import com.warehouse.entity.dailyPack.EfficiencyPerArea;
import com.warehouse.entity.dailySales.DailySales;
import com.warehouse.entity.dailySales.ReturnMiscPortion;
import com.warehouse.mapper.DailyPackMapper;
import com.warehouse.service.DailyPackService;
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
        //将当前商家数据返回
        return dailyPackMapper.findPackAvg(brandInfo);
    }

    @Override
    public List<DailyMaterial> countMaterialNum(RequestBrand brandInfo){
        return dailyPackMapper.countMaterialNum(brandInfo);
    }

    @Override
    public List<DailySku> countSkuRank(RequestBrand brandInfo) {
        return dailyPackMapper.countSkuRank(brandInfo);
    }

    @Override
    public List<DailySku> countPackGood(RequestBrand brandInfo){
        return dailyPackMapper.countPackGood(brandInfo);
    }

    @Override
    public DailySku countAvgSku(RequestBrand brandInfo){
        return dailyPackMapper.countAvgSku(brandInfo);

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

    @Override
    public List<EfficiencyPerArea> countEfficiency(RequestBrand brandInfo){
        List<EfficiencyPerArea> list = dailyPackMapper.countEfficiency(brandInfo);
        int n = list.size();
        if (n == 0) return list;
        if(list.get(0).getStartDate() != brandInfo.getStartDate()){
            list.get(0).setStartDate(brandInfo.getStartDate());
        }
        if(list.get(n-1).getEndDate() != brandInfo.getEndDate()){
            list.get(n-1).setEndDate(brandInfo.getEndDate());
        }
        return list;
    }

}
