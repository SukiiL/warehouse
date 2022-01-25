package com.crud.demo.service.impl;

import com.crud.demo.entity.dailySales.DailySales;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailySales.DailyGood;
import com.crud.demo.entity.dailySales.ReturnDailyGood;
import com.crud.demo.mapper.DailyPackMapper;
import com.crud.demo.mapper.DailySalesMapper;
import com.crud.demo.service.DailySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public ReturnDailyGood countDailyGood(RequestBrand brandInfo){
        List<DailyGood> dailyNums = dailySalesMapper.countDailyGood(brandInfo);
        int size = dailyNums.size();
        if(size == 0){
            return null;
        }
        ReturnDailyGood returnInfo = new ReturnDailyGood();
        int sum = 0;
        double avg = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        double mid = 0;
        double sd = 0;
        double dSum = 0;
        for(int i = 0; i < size; i++){
            Integer dailyGoodQuantity = dailyNums.get(i).getTotalGoodQuantity();
            sum += dailyGoodQuantity;
            max = Math.max(max,dailyGoodQuantity);
            min = Math.min(min,dailyGoodQuantity);
        }
        returnInfo.setDailySalesNum(dailyNums);//日发货量的集合
        avg = (double) (sum/size);
        returnInfo.setAvgSales(avg);//均值
        returnInfo.setMaxSales(max);//最大值
        returnInfo.setMinSales(min);//最小值
        if(size % 2 == 1){
            mid = dailyNums.get((size-1)/2).getTotalGoodQuantity();
        } else {
            mid = (dailyNums.get(size/2-1).getTotalGoodQuantity() + dailyNums.get(size/2).getTotalGoodQuantity())/2.0;
        }
        returnInfo.setMidSales(mid);//中位数

        for(DailyGood dailyNum:dailyNums){
            dSum += Math.pow(dailyNum.getTotalGoodQuantity() - avg,2);
        }
        sd = Math.sqrt(dSum / size);
        BigDecimal b = new BigDecimal(sd);
        sd = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        returnInfo.setSdSales(sd);//标准偏差
        return returnInfo;
    }


}
