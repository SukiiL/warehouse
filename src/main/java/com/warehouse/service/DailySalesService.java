package com.warehouse.service;

import com.warehouse.entity.dailySales.DailySales;
import com.warehouse.entity.RequestBrand;
import com.warehouse.entity.dailySales.ReturnDailyGood;

import java.util.List;
/**
 */
public interface DailySalesService {


    List<DailySales> countSalesRank(RequestBrand brandInfo);

    ReturnDailyGood countDailyGood(RequestBrand brandInfo);


}