package com.crud.demo.entity;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class DailyMaterial implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer bid;


    private Integer materialTypeId;

    /**
     * 包材所用数量
     */
    private Integer materialQuantity;

    /**
     * 包材占比
     */
    private BigDecimal materialPercent;

}
