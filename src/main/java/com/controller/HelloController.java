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
		System.out.println("方法运行了,得到的参数是"+userName);	
		request.setAttribute("request_msg", "Request: springmvc流成功 ");
		model.addAttribute("model_msg","model: springmvc流成功"); 
		modelMap.put("modelMap_msg","modelMap: springmvc流成功"); 
		map.put("map_msg","map: springmvc流成功"); 	
		return  "index";   //真正的视图 = prefix  +  逻辑视图 + suffix   /jsp/index.jsp	
	}
	
	@RequestMapping("/add")
	public String add(String name,String password,ModelMap m) {
		System.out.println(name +" "  +password);
		m.put("modelMap_msg", "这是另一个方法传的msg");
		return "index"; 	
	}
}
