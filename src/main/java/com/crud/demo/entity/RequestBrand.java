package com.crud.demo.entity;


import lombok.Data;

import java.sql.Date;

@Data
public class RequestBrand {

    private static final long serialVersionUID = 1L;

    /**
     * 商家编号
     */
    private Integer bid;

    /**
     * 查询的起始日期
     */
    private Date startDate;

    /**
     * 查询的截止日期
     */
    private Date endDate;


}
