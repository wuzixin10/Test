package com.mapper;

import java.util.List;

import com.entity.Comment;

/**
 * 评论 吴紫欣
 */
public interface CommentMapper {
	/**
	 * 查询最近的n条评论
	 * @param n 条数
	 * @return  列表
	 */
	List<Comment> listRecentComment(Integer n);
}
