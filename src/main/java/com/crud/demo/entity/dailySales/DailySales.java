package com.crud.demo.entity.dailySales;

import lombok.Data;

import java.io.Serializable;

@Data
public class DailySales implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * 商品code
     */
    private String goodId;

    /**
     * 日期区间商品总销量
     */
    private Integer goodSalesNum;

    /**
     * 商品销量排名
     */
    private Integer salesRank;

}