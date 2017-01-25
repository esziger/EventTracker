package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model){
		model.addAttribute("greeting", "Hello World");
		
		return "hello";	//The .jsp is needed because we don´t have a view-resolver yet
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		return "forward:index.jsp";
	}
}
