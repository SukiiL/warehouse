package com.crud.demo.entity.dailyPack;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;


@Data
public class ReturnAvg implements Serializable{

        private static final long serialVersionUID = 1L;

        /**
         * 商家编号
         */
        private Integer bid;


        /**
         * 包裹平均重量/kg
         */
        private BigDecimal avgWeight;

        /**
         * 包裹总价值/元
         */
        private BigDecimal avgPrice;


        /**
         * 包裹平均所含商品的种类数
         */
        private BigDecimal avgSku;

        /**
         * 包裹商品平均数目
         */
        private BigDecimal avgGoodQuantity;

    }

