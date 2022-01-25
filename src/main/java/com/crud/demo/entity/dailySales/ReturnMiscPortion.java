package com.crud.demo.entity.dailySales;

import com.crud.demo.entity.dailyPack.DailyTotal;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReturnMiscPortion implements Serializable {

    /**
     * 销量前N的商品中，杂单包裹所占的比例
     */

    List<DailySales> goodStat = new ArrayList<>();


    /**
     * 每日销量均值
     */
    private DailyTotal packStat;

}
