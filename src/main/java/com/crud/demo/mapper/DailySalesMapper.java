package com.crud.demo.mapper;

import com.crud.demo.entity.DailySales;
import com.crud.demo.entity.RequestBrand;
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


}