package com.warehouse.service.impl;

import com.warehouse.entity.Good;
import com.warehouse.mapper.GoodMapper;
import com.warehouse.service.GoodService;
import com.warehouse.service.exception.DeleteException;
import com.warehouse.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    //    按gid删除
    @Override
    public void deleteByGid(int gid) {
//        Good result = goodMapper.findByGid(gid);
//        if(result == null || result.getIsDelete() == 1){
//            throw new GoodNotFoundException("商品不存在");
//        }
        int rows = goodMapper.deleteByGid(gid);
        if(rows < 1){
            throw new DeleteException("数据删除过程中产生了未知异常");
        }
    }

    // 按bid查
    @Override
    public List<Good> findByBid(int bid) {
        // 判断商家是否存在
        List<Good> info = goodMapper.findByBid(bid);
        //将当前商家数据返回
        return info;
    }


    // 增/改
    @Override
    public void insert(List<Good> goodList){
        // 执行插入操作
        int rows = goodMapper.insert(goodList);
        if(rows < 1){
            throw new InsertException("数据更新过程中产生了未知异常");
        }
    }

//
//    @Override
//    public Good findByGid(int gid) {
//        return null;
//    }

}


