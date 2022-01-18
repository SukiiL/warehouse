package com.crud.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import java.io.Serializable;

@Data
@ExcelTarget("brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name="商家id")
    private Integer bid;
    private Integer isDelete;
    @Excel(name="商家名称")
    private String brandName;

}