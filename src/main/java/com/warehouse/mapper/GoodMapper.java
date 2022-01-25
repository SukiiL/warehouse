package com.warehouse.mapper;


import com.warehouse.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
    public interface GoodMapper {

        /**
         * 根据gid删除
         * @param gid
         * @return
         */
        int deleteByGid(int gid);

        /**
         * 根据bid删除
         * @param bid
         * @return
         */
        int deleteByBid(int bid);

        /**
         * 根据bid查询商品
         * @param bid
         * @return 如果找到商家则返回数据，没找到则返回null
         */
        List<Good> findByBid(int bid);

//
//        /**
//         * 根据gid查询商品
//         * @param gid
//         * @return 如果找到商家则返回数据，没找到则返回null
//         */
//        Good findByGid(int gid);

        /**
         * 增/改商品信息
         * @param goodList
         * @return
         */
        int insert (List<Good> goodList);

    }


