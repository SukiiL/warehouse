package com.warehouse.mapper;

import com.warehouse.entity.dailySales.DailyGood;
import com.warehouse.entity.dailySales.DailySales;
import com.warehouse.entity.RequestBrand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Mapper
@Repository
public interface DailySalesMapper {


    /**
     * 根据bid和date查找商家每日销量排名
     * @param brandInfo
     * @return
     */
    List<DailySales> countSalesRank(RequestBrand brandInfo);

    /**
     * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
     * @param brandInfo
     * @return
     */
    List<DailyGood> countDailyGood(RequestBrand brandInfo);



}