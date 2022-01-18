package com.crud.demo.service.impl;

import com.crud.demo.entity.DailySales;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.mapper.DailySalesMapper;
import com.crud.demo.service.DailySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailySalesServiceImpl implements DailySalesService {

    @Autowired
    private DailySalesMapper dailySalesMapper;


    @Override
    public List<DailySales> countSalesRank (RequestBrand brandInfo) {
        List<DailySales> rankInfo = dailySalesMapper.countSalesRank(brandInfo);
        return rankInfo;
    }
}
