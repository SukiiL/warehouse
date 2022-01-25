package com.warehouse.service;

import com.warehouse.entity.dailyPack.DailyMaterial;
import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailyPack.DailySku;
import com.warehouse.entity.dailyPack.DailyTotal;
import com.warehouse.entity.dailySales.ReturnMiscPortion;

import java.util.List;


public interface DailyPackService {

    DailyTotal findPackAvg(RequestBrand brandInfo);

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


    /**
     * 根据bid和date查找商家各sku数目下的商品数
     * @param brandInfo
     * @return
     */
    List<DailySku> countPackGood(RequestBrand brandInfo);

    /**
     * 根据bid和date查找商家sku > 1的包裹的平均sku数
     * @param brandInfo
     * @return
     */
    DailySku countAvgSku(RequestBrand brandInfo);

    ReturnMiscPortion countMiscPortion(RequestBrand brandInfo);
}


