package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.Category;
import com.entity.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ArticleMapper;
import com.mapper.CategoryMapper;
import com.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private CategoryMapper categoryMapper;
	@Override
	public List<Article> listRecentArticle(Integer n) {
		return articleMapper.listRecentArticle(n);
	}

	
	public PageInfo<Article> getPageArticleList(Integer pageIndex, Integer pageSize) {	
		PageHelper.startPage(pageIndex,pageSize);
		
		List<Article> articleList= articleMapper.findAll();
		
		//��ÿ���ļ���Ӧ�ķ����Ŵ������
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		
		return new PageInfo<>(articleList);
	}
	
	
	public void addArticle(Article article) {
		//���������Ϣ�����±�
		articleMapper.addArticle(article); 
		
		//������ºͷ���Ķ�Ӧ��Ϣ
		for(Category c: article.getCategoryList()) {
			articleMapper.addArticleCategory(article.getArticleId(),c.getCategoryId());	
		}

		//������ºͱ�ǩ�Ķ�Ӧ��Ϣ
		for(Tag t: article.getTagList()) {
			articleMapper.addArticleTag(article.getArticleId(),t.getTagId());
		}
	}


}
