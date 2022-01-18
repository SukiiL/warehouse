package com.crud.demo.mapper;


import com.crud.demo.entity.DailyMaterial;
import com.crud.demo.entity.RequestBrand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DailyMaterialMapper {

    /**
     * 根据bid和date查找商家所用包材的数量及其占比
     * @param brandInfo
     * @return
     */
    List<DailyMaterial> countMaterialNum(RequestBrand brandInfo);

}
