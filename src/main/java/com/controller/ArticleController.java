package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.entity.Article;
import com.entity.Category;
import com.entity.Tag;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.CategoryService;
import com.service.TagService;
import cn.hutool.http.HtmlUtil;

@Controller @RequestMapping("/article")
public class ArticleController {	
	
	@Resource
	ArticleService articleService;
	
	@Resource
	CategoryService categoryService;
	
	@Resource
	TagService tagService;
	
	/**
	 * ת���������ҳ��,��Ϊ�����ҳ����Ҫ�õ������б�ͱ�ǩ�б�,����Ҫ����ȥ
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)   //GET �������������
	public String gotoAddPage(ModelMap m){
		//��ѯ������Ϣ
		List<Category> categoryList=categoryService.listCategory();
		
		//��ѯ��ǩ��Ϣ
		List<Tag> tagList=tagService.listTag();
		
		//����ȥ
		m.put("categoryList", categoryList);
		m.put("tagList", tagList);
		
		//ת��
		return "Article/article-add"; 		
	}
	
@RequestMapping(value="/add", method=RequestMethod.POST)  //POST �������������
	public String add(ModelMap m,HttpServletRequest request){
		Article article=new Article();
		
		//ȡ��ǰ�û���id
		User user=(User)request.getSession().getAttribute("session_user");
		if(user!=null) {
			article.setArticleUserId(user.getUserId());
		}
		
		//���±���
		article.setArticleTitle(request.getParameter("articleTitle"));
		
		//��������
		article.setArticleContent(request.getParameter("articleContent"));
		
		//���µ�״̬
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));
		
		//����ժҪ
		String str=HtmlUtil.cleanHtmlTag(article.getArticleContent());
		article.setArticleSummary(str.length()>150?str.substring(0,150):str);
		
		//���µķ���ʱ��
		article.setArticleCreateTime(new Date());
		
		//���µ�������ʱ��
		article.setArticleUpdateTime(new Date());
		
		//�Ѽ��������óɳ�ʼֵ 0
		article.setArticleViewCount(0);
		article.setArticleLikeCount(0);
		article.setArticleCommentCount(0);
		
		//��������
		article.setArticleOrder(1);
		
		//һ�������id
		int  parentCateId=Integer.parseInt(request.getParameter("articleParentCategoryId"));
		
		//���������id
		int childCateId=Integer.parseInt(request.getParameter("articleChildCategoryId"));
		
		//���������������װ��list��
		List<Category> categoryList=new ArrayList<>(2);
		categoryList.add(new Category(parentCateId));
		categoryList.add(new Category(childCateId));

		//��ǩ�б�
		String [] tagIds =request.getParameterValues("articleTagIds");
		
		//������ı�ǩ�ŵ�list��
		List<Tag> tagList=new ArrayList<>();
		for(String tagId:tagIds) {
			tagList.add(new Tag(Integer.parseInt(tagId)));
		}
	
		//�ѷ���ͱ�ǩ��Ϣ����article��
		article.setCategoryList(categoryList);
		article.setTagList(tagList);
		
		//�������
		articleService.addArticle(article);
		
		//������ת������ѯ��������
		return "forward:/article"; 
	}
	
	@RequestMapping("")
	public String index(
	        @RequestParam(required = false,defaultValue="1")  Integer pageIndex,  
			@RequestParam(required = false,defaultValue="10") Integer pageSize,ModelMap m) {
				
		PageInfo<Article> pageInfo= articleService.getPageArticleList(pageIndex,pageSize);
		
		m.put("pageInfo", pageInfo);
		
		//-------------��ӡһ�·�ҳ��ص���Ϣ -------------
		System.out.println("getEndRow:" + pageInfo.getEndRow());
		System.out.println("getNextPage:" + pageInfo.getNextPage());
		System.out.println("getPageNum:" + pageInfo.getPageNum());
		System.out.println("getPages:" + pageInfo.getPages());
		System.out.println("getPageSize:" + pageInfo.getPageSize());
		
		m.put("pageUrlPrefix","article?pageIndex"); //��ǰ׺������ҳ�ĵ���ҳ
							
		return "Article/article-list";
	}
}