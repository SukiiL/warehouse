package com.crud.demo.service.impl;

import com.crud.demo.entity.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import com.crud.demo.mapper.DailyMaterialMapper;
import com.crud.demo.service.DailyMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DailyMaterialServiceImpl implements DailyMaterialService {

    @Autowired
    private DailyMaterialMapper dailyMaterialMapper;


    @Override
    public List<DailyMaterial> countMaterialNum(RequestBrand brandInfo){
        List<DailyMaterial> selectRes = dailyMaterialMapper.countMaterialNum(brandInfo);
        return selectRes;
    }
}
