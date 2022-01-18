package com.crud.demo.mapper;

import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyAvg.DailyAvg;
import com.crud.demo.entity.dailyAvg.DailyGood;
import com.crud.demo.entity.dailyAvg.ReturnAvg;
import com.crud.demo.entity.dailyAvg.ReturnDailyGood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 */
@Mapper
@Repository
public interface DailyAvgMapper {


    /**
     * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
     * @param brandInfo
     * @return
     */
    ReturnAvg findPackAvg(RequestBrand brandInfo);

    /**
     * 根据bid和date查找商家包裹重量均值、价值均值、sku均值、包裹所含商品数目均值
     * @param brandInfo
     * @return
     */
    List<DailyGood> countDailyGood(RequestBrand brandInfo);

}