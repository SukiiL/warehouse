package com.crud.demo.entity.dailySales;

import lombok.Data;

import java.sql.Date;
import java.io.Serializable;

@Data
public class DailyGood implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * date
     */
    private Date date;


    /**
     * 包裹商品总数目
     */
    private Integer totalGoodQuantity;

}