package com.crud.demo.entity.dailyAvg;


import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReturnDailyGood {

    /**
     * 商家商品日销量和date的集合
     */

    List<DailyGood> dailySalesNum = new ArrayList<>();


    /**
     * 每日销量均值
     */
    private Double avgSales;

    /**
     * 日销量最大值
     */
    private Integer maxSales;

    /**
     * 日销量最低值
     */
    private Integer minSales;

    /**
     * 日销量中位数
     */
    private Double midSales;

    /**
     * 日销量标准偏差
     */
    private Double sdSales;


}
