package com.crud.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("good")
public class Good implements Serializable {

    @Excel(name="商品id")
    private Integer gid;
    @Excel(name="商家id")
    private Integer bid;
    @Excel(name="商品名称")
    private String name;
    @Excel(name="商品编号")
    private String goodId;
    @Excel(name="所需托盘")
    private Double tray;
    @Excel(name="重量/kg")
    private Double weight;
    @Excel(name="长/cm")
    private Double length;
    @Excel(name="宽/cm")
    private Double width;
    @Excel(name="高/cm")
    private Double height;
    @Excel(name="价格/元")
    private Double price;

    private Integer isDelete;

}
