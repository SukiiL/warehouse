package com.warehouse.service;

import com.warehouse.entity.Brand;

import java.util.List;

public interface BrandService {

	/**
	 * @param brandList
	 * 新增
	 */
	void  insert(List<Brand> brandList);


	/**
	 * 删除
	 */
	void deleteByBid(int bid);



}