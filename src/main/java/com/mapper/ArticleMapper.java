package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Article;

/**
 * 文章管理
 * @author 吴紫欣
 */
public interface ArticleMapper {
	/**
	 * 查询前n条文章
	 * @param n  要查出来的文章数
	 * @return 文章列表
	 */
	List<Article> listRecentArticle(Integer n);
	/** 
	 * 查询所有文章数据
	 * @return 文章列表
	 */
	List<Article> findAll();
	/**
	 * 添加文章信息
	 * @param article
	 */
	void addArticle(Article article);

	  /**
	 * 添加文章和分类的关联
	 * @param articleId 文章ID
	 * @param categoryId 分类ID
	 */
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer  categoryId); 

	/**
	 * 添加文章和标签的关联
	 * @param articleId 文章ID
	 * @param tagId 标签ID
	 */
	void addArticleTag(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);
	

	

}
