package com.crud.demo.service;

import com.crud.demo.entity.dailyPack.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyPack.DailySku;
import com.crud.demo.entity.dailyPack.ReturnAvg;

import java.util.List;


public interface DailyPackService {

    ReturnAvg findPackAvg(RequestBrand brandInfo);

    /**
     * 根据bid和date查找商家所用包材的数量及其占比
     * @param brandInfo
     * @return
     */
    List<DailyMaterial> countMaterialNum(RequestBrand brandInfo);

    /**
     * 根据bid和date查找商家sku情况统计，包括特定sku数目下的包裹数及包裹数占比，按照占比从高到底排列
     * @param brandInfo
     * @return
     */
    List<DailySku> countSkuRank(RequestBrand brandInfo);

}


