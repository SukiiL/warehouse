package com.crud.demo.entity.dailyAvg;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.io.Serializable;

@Data
public class DailyAvg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 商家编号
     */
    private Integer bid;

    /**
     * date
     */
    private Date date;

    /**
     * 包裹总重量/kg
     */
    private BigDecimal totalWeight;

    /**
     * 包裹总价值/元
     */
    private BigDecimal totalPrice;

    /**
     * 包裹总数
     */
    private Integer packNum;

    /**
     * 包裹总所含商品的种类数
     */
    private Integer totalSku;

    /**
     * 包裹商品总数目
     */
    private Integer totalGoodQuantity;

}