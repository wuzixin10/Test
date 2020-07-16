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
		
		//把每个文件对应的分类信处查出来
		for(Article a:articleList) {
			List<Category> categoryList=categoryMapper.listCategoryByArticleId(a.getArticleId());
			a.setCategoryList(categoryList);
		}
		
		return new PageInfo<>(articleList);
	}
	
	
	public void addArticle(Article article) {
		//添加文章信息到文章表
		articleMapper.addArticle(article); 
		
		//添加文章和分类的对应信息
		for(Category c: article.getCategoryList()) {
			articleMapper.addArticleCategory(article.getArticleId(),c.getCategoryId());	
		}

		//添加文章和标签的对应信息
		for(Tag t: article.getTagList()) {
			articleMapper.addArticleTag(article.getArticleId(),t.getTagId());
		}
	}


}
