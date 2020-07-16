package com.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Comment;
import com.entity.User;
import com.service.ArticleService;
import com.service.CommentService;
import com.service.UserService;




@Controller @RequestMapping("/admin")
public class AdminController {	
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleService;
	@Resource
	private CommentService commentService;

	@RequestMapping("/login")
	public String login(String userName,String userPass,ModelMap m,HttpSession session) {	
		User user=userService.login(userName, userPass);
		
		if(user!=null) {
			m.put("msg", "登录成功");
			session.setAttribute("session_user", user);	
			
			List<Article> articleList=articleService.listRecentArticle(6);
			m.put("articleList", articleList);
			
			List<Comment> commentList =commentService.listRecentComment(6);
			m.put("commentList", commentList);

			return "index"; 
		}
		else {
			m.put("msg", "用户名或密码错误,登录失败");
			return "login";  
		}
	}
}

