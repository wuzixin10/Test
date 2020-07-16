package com.mapper;

import java.util.List;

import com.entity.Tag;

public interface TagMapper {
	/**
	 * 查询标签列表 
	 * @return 标签列表
	 */
	public List<Tag> listTag();


}
