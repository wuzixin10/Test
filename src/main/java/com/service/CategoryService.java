package com.service;

import java.util.List;

import com.entity.Category;

public interface CategoryService {
	/**
	 * 查询分类列表
	 * @return 分类列表
	 */
	List<Category> listCategory();


}
