package com.crud.demo.service;

import com.crud.demo.entity.dailySales.DailySales;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailySales.ReturnDailyGood;

import java.util.List;
/**
 */
public interface DailySalesService {


    List<DailySales> countSalesRank(RequestBrand brandInfo);

    ReturnDailyGood countDailyGood(RequestBrand brandInfo);
}