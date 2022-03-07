package com.warehouse.mapper;

import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailyPack.DailyMaterial;
import com.warehouse.entity.dailyPack.DailySku;
import com.warehouse.entity.dailyPack.DailyTotal;
import com.warehouse.entity.dailyPack.EfficiencyPerArea;
import com.warehouse.entity.dailySales.DailySales;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 */
@Mapper
@Repository
public interface DailyPackMapper {


    /**
     * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
     * @param brandInfo
     * @return
     */
    DailyTotal findPackAvg(RequestBrand brandInfo);



    /**
     * 根据bid和date查找商家所用包材的数量及其占比
     * @param brandInfo
     * @return
     */
    List<DailyMaterial> countMaterialNum(RequestBrand brandInfo);


    /**
     * 根据bid和date查找商家sku情况统计，包括特定sku数目下的包裹数及包裹数占比，按照占比从高到底排列。
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

    /**
     * 根据bid，date和N查找商家每个商品杂单包裹比例
     * @param brandInfo
     * @return
     */
    List<DailySales> goodMiscPortion(RequestBrand brandInfo);

    /**
     * 根据bid，date查找商家杂单包裹比例
     * @param brandInfo
     * @return
     */
    DailyTotal packMiscPortion(RequestBrand brandInfo);

    /**
     * 根据bid，date查找商家平效
     */
    List<EfficiencyPerArea> countEfficiency(RequestBrand brandInfo);
}