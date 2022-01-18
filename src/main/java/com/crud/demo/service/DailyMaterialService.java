package com.crud.demo.service;

import com.crud.demo.entity.DailyMaterial;
import com.crud.demo.entity.RequestBrand;

import java.util.List;

public interface DailyMaterialService {
    /**
     * 根据bid和date查找商家所用包材的数量及其占比
     * @param brandInfo
     * @return
     */
    List<DailyMaterial> countMaterialNum(RequestBrand brandInfo);
}
