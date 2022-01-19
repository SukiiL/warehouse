package com.crud.demo.entity.dailyPack;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DailySku implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer bid;


    private Integer sku;

    /**
     * sku对应包裹数量
     */
    private Integer packNum;

    /**
     * 该sku包裹数占比
     */
    private BigDecimal skuPackPercent;

    /**
     * 该sku包裹数占比排名
     */
    private Integer skuPackRank;
}
