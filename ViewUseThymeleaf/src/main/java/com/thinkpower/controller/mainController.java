package com.thinkpower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class mainController {
	
	@RequestMapping(value= {"","/"})
	public String toMainPage() {
		return "main";
	}
}
