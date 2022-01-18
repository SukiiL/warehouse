package com.crud.demo.service;

import com.crud.demo.entity.RequestBrand;
import com.crud.demo.entity.dailyAvg.ReturnAvg;
import com.crud.demo.entity.dailyAvg.ReturnDailyGood;

import java.util.List;


public interface DailyAvgService {

    ReturnAvg findPackAvg(RequestBrand brandInfo);

    ReturnDailyGood countDailyGood(RequestBrand brandInfo);
}
