package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Article;

/**
 * ���¹���
 * @author ������
 */
public interface ArticleMapper {
	/**
	 * ��ѯǰn������
	 * @param n  Ҫ�������������
	 * @return �����б�
	 */
	List<Article> listRecentArticle(Integer n);
	/** 
	 * ��ѯ������������
	 * @return �����б�
	 */
	List<Article> findAll();
	/**
	 * ���������Ϣ
	 * @param article
	 */
	void addArticle(Article article);

	  /**
	 * ������ºͷ���Ĺ���
	 * @param articleId ����ID
	 * @param categoryId ����ID
	 */
	void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryId") Integer  categoryId); 

	/**
	 * ������ºͱ�ǩ�Ĺ���
	 * @param articleId ����ID
	 * @param tagId ��ǩID
	 */
	void addArticleTag(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);
	

	

}
