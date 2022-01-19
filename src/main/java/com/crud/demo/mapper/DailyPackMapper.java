package com.crud.demo.mapper;

import com.crud.demo.entity.dailyPack.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyPack.DailySku;
import com.crud.demo.entity.dailyPack.ReturnAvg;
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
    ReturnAvg findPackAvg(RequestBrand brandInfo);



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

}