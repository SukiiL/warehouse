package com.crud.demo.mapper;

import com.crud.demo.entity.Brand;
import com.crud.demo.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface BrandMapper {


    /**
     * 根据bid删除
     * @param bid
     * @return 受影响的行数
     **/
    int deleteByBid(int bid);


    /**
    * 增/改
    **/
    int insert(List<Brand> brandList);

}