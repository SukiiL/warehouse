package com.warehouse.service;

import com.warehouse.entity.Good;

import java.util.List;

public interface GoodService {


    /**
     * 根据 bid 查询
     */
    List<Good> findByBid(int bid);

//
//
//    /**
//     * 根据 gid 查询
//     */
//    Good findByGid(int gid);


    /**
     * 按gid删除
     */
    void deleteByGid(int gid);

    /**
     * 增/改
     * @param goodList
     */
    void insert(List<Good> goodList);




}