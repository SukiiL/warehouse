package com.warehouse.entity.dailyPack;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class EfficiencyPerArea implements Serializable {
    private static final long serialVersionUID = 1L;


    private BigDecimal efficiencyPerSquareMeter;

    private Date startDate;

    private Date endDate;


}
