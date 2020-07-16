package com.service;

import java.util.List;

import com.entity.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	/**
	 * 查询前n条文章
	 * @param n  要查出来的文章数
	 * @return 文章列表
	 */
	List<Article> listRecentArticle(Integer n);

	/**
	 * 分页查询文章列表
	 * @param pageIndex  从第几页开始 
	 * @param pageSize 每页多少条数据
	 * @return  文章列表数据,并且用PageInfo 进行了包装
	 */

	PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);
	/**
	 * 发布文章
	 * @param article 文章信息
	 */
	void addArticle(Article article);



}
