package com.crud.demo.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class RequestBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商家编号
     */
    private int bid;

    /**
     * 查询的起始日期
     */
    private Date startDate;

    /**
     * 查询的截止日期
     */
    private Date endDate;

    /**
     * 销量前N的商品
     */
    private int n;

    /**
     * mybatis的limit动态传参
     */
    private int limit;

    public int getLimit() {
        return n;
    }


}
