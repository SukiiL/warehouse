package com.crud.demo.entity.dailyPack;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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


    /**
     * 各sku包裹的平均商品数
     */
    private BigDecimal packAvgGoodQuantity;

    /**
     * sku > 1的包裹的平均sku数
     */
    private BigDecimal avgSku;
}
