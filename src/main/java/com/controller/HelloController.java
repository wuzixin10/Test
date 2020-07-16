package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/test")
public class HelloController {	
	
	@RequestMapping("/hello")
	public String exec(String userName,HttpServletRequest request, Model model,ModelMap modelMap,Map map) {
		System.out.println("����������,�õ��Ĳ�����"+userName);	
		request.setAttribute("request_msg", "Request: springmvc���ɹ� ");
		model.addAttribute("model_msg","model: springmvc���ɹ�"); 
		modelMap.put("modelMap_msg","modelMap: springmvc���ɹ�"); 
		map.put("map_msg","map: springmvc���ɹ�"); 	
		return  "index";   //��������ͼ = prefix  +  �߼���ͼ + suffix   /jsp/index.jsp	
	}
	
	@RequestMapping("/add")
	public String add(String name,String password,ModelMap m) {
		System.out.println(name +" "  +password);
		m.put("modelMap_msg", "������һ����������msg");
		return "index"; 	
	}
}
