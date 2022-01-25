package com.crud.demo.entity.dailySales;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailySales implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String goodName;

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

    /**
     * 该商品一共打包在多少个杂单包裹中
     */
    private Integer miscPackQuantity;

    /**
     * 该商品一共打包在多少个包裹中
     */
    private Integer packQuantity;

    /**
     * 杂单包裹数占比
     */
    private BigDecimal miscPackPortion;


}