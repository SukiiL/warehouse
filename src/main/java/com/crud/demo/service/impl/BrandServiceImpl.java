package com.crud.demo.service.impl;

import com.crud.demo.entity.Brand;
import com.crud.demo.entity.Good;
import com.crud.demo.mapper.BrandMapper;
import com.crud.demo.mapper.GoodMapper;
import com.crud.demo.service.BrandService;
import com.crud.demo.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private GoodMapper goodMapper;

    // 商家、商品表都删除该商家
    @Override
    public void deleteByBid(int bid) {
//        Good result = goodMapper.findByBid(bid);
//        if(result == null || result.getIsDelete() == 1){
//            // 没添加过这个商家或者已被删除
//            throw new BrandNotFoundException("商家未录入商品");
//        }
        int brows = brandMapper.deleteByBid(bid);
        int grows = goodMapper.deleteByBid(bid);
        if(brows < 1 || grows < 1){
            throw new DeleteException("数据删除过程中产生了未知异常");
        }
    }

    //增/改商家信息
    @Override
    public void insert(List<Brand> brandList){
        // 执行插入操作
        int rows = brandMapper.insert(brandList);
        if(rows < 1){
            throw new InsertException("数据更新过程中产生了未知异常");
        }
    }

}