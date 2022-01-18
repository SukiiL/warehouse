package com.crud.demo.service;

import com.crud.demo.entity.DailySales;
import com.crud.demo.entity.RequestBrand;

import java.util.List;
/**
 */
public interface DailySalesService {


    List<DailySales> countSalesRank(RequestBrand brandInfo);

//    /**
//    * 分页查询
//    */
//    public Map<String,Object> pageList(int offset, int pagesize);

}