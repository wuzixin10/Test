package com.service;

import java.util.List;

import com.entity.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {
	/**
	 * ��ѯǰn������
	 * @param n  Ҫ�������������
	 * @return �����б�
	 */
	List<Article> listRecentArticle(Integer n);

	/**
	 * ��ҳ��ѯ�����б�
	 * @param pageIndex  �ӵڼ�ҳ��ʼ 
	 * @param pageSize ÿҳ����������
	 * @return  �����б�����,������PageInfo �����˰�װ
	 */

	PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize);
	/**
	 * ��������
	 * @param article ������Ϣ
	 */
	void addArticle(Article article);



}
